package org.bluebridge.utils.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSHA256Util {

    /**
     * HmacSHA256 散列消息认证码
     *
     * @param data   要进行加密的数据
     * @param secret 加密密钥
     * @return 加密后的字节数组
     * @throws Exception 异常
     */
    public static byte[] encrypt(byte[] data, byte[] secret) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(secret, "HmacSHA256");
        mac.init(secretKeySpec);
        return mac.doFinal(data);
    }

}
