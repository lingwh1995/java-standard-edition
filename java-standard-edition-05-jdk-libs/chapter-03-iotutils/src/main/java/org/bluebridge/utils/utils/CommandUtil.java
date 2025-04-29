package org.bluebridge.utils.utils;

import cn.hutool.core.util.HexUtil;

import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Random;

public class CommandUtil {
    /**
     * 组装命令的模板方法
     * @param commandCode 命令码
     * @return
     * @throws Exception
     */
    public final String buildCommand(String commandCode) throws Exception {
        byte[] dataAreaBytes = new byte[]{};
        //如果需要补全数据区则进行以下处理
        if(isPaddingDataArea()) {
            dataAreaBytes = paddingDataArea(dataAreaBytes);
        }
        //如果需要加密数据区则进行以下处理
        if(isEncrypDataArea()) {
            dataAreaBytes = encryptDataArea(dataAreaBytes);
        }
        //如果计算mac并将计算结果拼接到数据区尾部
        if(isCalcMacAndAppendMacToDataAreaTail()) {
            dataAreaBytes = calcMacAndAppendMacToDataAreaTail(dataAreaBytes);
        }
        byte[] downlinkBytes = buildPackage(dataAreaBytes, commandCode);
        return HexUtil.encodeHexStr(downlinkBytes);
    }

    /**
     * 构建命令明文数据区
     * @return 数据区
     */
    protected byte[] buildDataArea() {
        return null;
    }

    /**
     * 补齐数据区
     *      需要16字节补齐，报文长度少于16个字节，需要补满16个字节，补(16-len)个(16-len)。
     *      如果报文长度正好时N字节的整数倍，则需要补16个十进制16。
     * @param dataArea 没有补齐的数据区
     * @return 补齐后的数据区
     */
    protected byte[] paddingDataArea(byte[] dataArea) {
        byte[] paddingDataArea;
        int paddingNumber = dataArea.length % 16;
        if (paddingNumber == 0) {
            int length = dataArea.length + 16;
            paddingDataArea = new byte[length];
            System.arraycopy(dataArea, 0, paddingDataArea, 0, dataArea.length);
            for (int i = dataArea.length; i < paddingDataArea.length; i++) {
                paddingDataArea[i] = (byte) 16;
            }
        } else {
            int value = 16 - paddingNumber;
            paddingDataArea = new byte[dataArea.length + value];
            System.arraycopy(dataArea, 0, paddingDataArea, 0, dataArea.length);
            for (int i = dataArea.length; i < paddingDataArea.length; i++) {
                paddingDataArea[i] = (byte) value;
            }
        }
        return paddingDataArea;
    }

    /**
     * 加密数据区
     * @param paddingDataArea 补齐后的数据区
     * @return 加密后的数据区
     * @throws Exception
     */
    protected byte[] encryptDataArea(byte[] paddingDataArea) throws Exception {
        byte[] mainSecretBytes = ParseUtil.hexStringToByte(mainSecret);
        return AESUtil.encrypt(paddingDataArea, mainSecretBytes);
    }

    /**
     * 计算mac并且把计算后的mac值拼接到数据区尾部
     * @param encryptDataArea 加密后的数据区
     * @return 可以直接用于组包的数据区
     * @throws Exception
     */
    protected byte[] calcMacAndAppendMacToDataAreaTail(byte[] encryptDataArea) throws Exception {
        String randomCommunicationCode = String.valueOf(redisTemplate.opsForValue()
                .get(configurations.getProjectCachePrefix() + configurations.getRandomCommunicationCodeCachePrefix() + deviceId));
        byte[] randomCommunicationCodeBytes = Base64Util.hexStringToByte(randomCommunicationCode);
        byte[] mainSecretBytes = Base64Util.hexStringToByte(mainSecret);
        //使用主密钥对随机通信码进行AES128计算取前16字节得到加密密钥
        byte[] secretKeyBytes = AESUtil.encrypt(randomCommunicationCodeBytes, mainSecretBytes);
        secretKeyBytes = secretKeyBytes.length > 16 ? Arrays.copyOfRange(secretKeyBytes, 0, 16) : secretKeyBytes;

        //1.在数据对象前面添加随机通信码
        byte[] calcDataAreaBytes = new byte[randomCommunicationCodeBytes.length + encryptDataArea.length];
        System.arraycopy(randomCommunicationCodeBytes, 0, calcDataAreaBytes, 0, randomCommunicationCodeBytes.length);
        System.arraycopy(encryptDataArea, 0, calcDataAreaBytes, randomCommunicationCodeBytes.length, encryptDataArea.length);
        //2.经过MAC算法计算出MAC值
        byte[] mac = HmacSHA256.encrypt(calcDataAreaBytes, secretKeyBytes);
        //3.最后将MAC追加在数据对象内容后作为数据域。
        byte[] finalDataArea = new byte[encryptDataArea.length + mac.length];
        System.arraycopy(encryptDataArea, 0, finalDataArea, 0, encryptDataArea.length);
        System.arraycopy(mac, 0, finalDataArea, encryptDataArea.length, mac.length);
        return finalDataArea;
    }

    /**
     * 构建升级包
     * @param dataArea
     * @param commandCode
     * @return
     */
    protected byte[] buildPackage(byte[] dataArea, String commandCode) throws Exception {
        int frameLength = 12 + dataArea.length;
        byte[] frameBytes = new byte[frameLength];
        //设置帧头
        frameBytes[0] = 0x68;
        //设置协议类型
        frameBytes[1] = 0x0;
        //设置协议框架版本
        frameBytes[2] = 0x1;
        //设置帧长度
        byte[] frameLengthBytes = Base64Util.numberToHexBytes(frameLength, ByteOrder.BIG_ENDIAN, 0, 2);
        System.arraycopy(frameLengthBytes, 0, frameBytes, 3, 2);
        //设置消息序号
        frameBytes[5] = (byte) new Random().nextInt();
        //设置控制域
        frameBytes[6] = (byte) 0x85;
        //设置数据对象id
        byte[] commandCodeBytes = HexUtil.decodeHex(commandCode);
        System.arraycopy(commandCodeBytes, 0, frameBytes, 7, 2);
        // 设置数据域
        System.arraycopy(dataArea, 0, frameBytes, 9, dataArea.length);
        //设置CRC
        byte[] calcCrcBytes = Arrays.copyOfRange(frameBytes, 5, frameBytes.length - 3);
        long checkSum = CRCUtil.XModem(calcCrcBytes);
        byte[] crcBytes = Base64Util.numberToHexBytes(checkSum, ByteOrder.BIG_ENDIAN, 0, 2);
        System.arraycopy(crcBytes, 0, frameBytes, frameBytes.length - 3, 2);
        // 设置帧尾
        frameBytes[frameBytes.length - 1] = 0x16;
        return frameBytes;
    }

    /**
     * 是否补全数据区
     * @return
     */
    protected boolean isPaddingDataArea() {
        return true;
    }

    /**
     * 是否加密数据区
     * @return
     */
    protected boolean isEncrypDataArea() {
        return true;
    }

    /**
     * 是否计算mac并将计算结果拼接到数据区尾部
     * @return
     */
    protected boolean isCalcMacAndAppendMacToDataAreaTail() {
        return true;
    }

    /**
     * 解析命令的方法（把加密报文中的数据区以名文形式解析处理）
     *
     * @param data 命令二进制格式
     * @param isVerifyWithMac 是否校验mac
     * @return
     * @throws Exception
     */
    public String parseCommand(byte[] data,boolean isVerifyWithMac) throws Exception {
        //从命令中获取数据区
        byte[] dataArea = Arrays.copyOfRange(data, 9, data.length - 3);
        if(isVerifyWithMac) {
            //移除数据区中的mac部分
            dataArea = Arrays.copyOfRange(dataArea, 0, dataArea.length - 32);
        }
        byte[] mainSecretBytes = ParseUtil.hexStringToByte(mainSecret);
        //解密数据区
        return HexUtil.encodeHexStr(AESUtil.decrypt(dataArea, mainSecretBytes));
    }
}
