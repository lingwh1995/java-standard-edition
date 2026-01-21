package org.bluebridge.utils;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ImageRotationUtils {

    /**
     * 通用的图片旋转方法
     * @param imageData 图像数据
     * @param width 图像宽度
     * @param height 图像高度
     * @param degrees 旋转角度（90, 180, 270）
     * @return 旋转后的图像数据
     */
    public static byte[] rotateImage(byte[] imageData, int width, int height, int degrees) {
        switch (degrees) {
            case 90:
                return rotate90Clockwise(imageData, width, height);
            case 180:
                return rotate180(imageData, width, height);
            case 270:
                return rotate90CounterClockwise(imageData, width, height);
            default:
                throw new IllegalArgumentException("只支持90, 180, 270度旋转");
        }
    }

    /**
     * 顺时针旋转90度
     */
    private static byte[] rotate90Clockwise(byte[] imageData, int width, int height) {
        int newWidth = height;
        int newHeight = width;
        byte[] rotatedData = new byte[imageData.length];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int originalIndex = y * width + x;
                int newX = y;
                int newY = width - 1 - x;
                int rotatedIndex = newY * newWidth + newX;
                rotatedData[rotatedIndex] = imageData[originalIndex];
            }
        }
        return rotatedData;
    }

    /**
     * 逆时针旋转90度（等同于顺时针旋转270度）
     */
    private static byte[] rotate90CounterClockwise(byte[] imageData, int width, int height) {
        int newWidth = height;
        int newHeight = width;
        byte[] rotatedData = new byte[imageData.length];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int originalIndex = y * width + x;
                int newX = height - 1 - y;
                int newY = x;
                int rotatedIndex = newY * newWidth + newX;
                rotatedData[rotatedIndex] = imageData[originalIndex];
            }
        }
        return rotatedData;
    }

    /**
     * 旋转180度
     */
    private static byte[] rotate180(byte[] imageData, int width, int height) {
        byte[] rotatedData = new byte[imageData.length];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int originalIndex = y * width + x;
                int rotatedX = width - 1 - x;
                int rotatedY = height - 1 - y;
                int rotatedIndex = rotatedY * width + rotatedX;
                rotatedData[rotatedIndex] = imageData[originalIndex];
            }
        }
        return rotatedData;
    }

    /**
     * 旋转JPEG图片，保持原始尺寸
     * @param jpegData 原始JPEG图片字节数组
     * @param degrees 旋转角度（90, 180, 270）
     * @return 旋转后的JPEG图片字节数组
     * @throws IOException 如果图片解码或编码失败
     */
    public static byte[] rotateJpegByDegrees(byte[] jpegData, int degrees) throws IOException {
        // 解码JPEG图片
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(jpegData));
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        BufferedImage rotatedImage;
        
        switch (degrees) {
            case 90:
            case 270:
            case -90:
                // 90度或270度旋转时，需要先创建一个宽高互换的临时图像进行旋转，然后缩放回原始尺寸
                // 创建旋转后的图像（宽高互换）
                BufferedImage tempRotated = new BufferedImage(height, width, originalImage.getType());
                Graphics2D g2d = tempRotated.createGraphics();
                
                if (degrees == 90) {
                    g2d.translate(height / 2.0, width / 2.0);
                    g2d.rotate(Math.PI / 2);
                    g2d.translate(-width / 2.0, -height / 2.0);
                } else { // 270度或-90度
                    g2d.translate(height / 2.0, width / 2.0);
                    g2d.rotate(-Math.PI / 2);
                    g2d.translate(-width / 2.0, -height / 2.0);
                }
                
                g2d.drawImage(originalImage, 0, 0, null);
                g2d.dispose();
                
                // 将旋转后的图像缩放回原始尺寸
                rotatedImage = new BufferedImage(width, height, originalImage.getType());
                Graphics2D g2dFinal = rotatedImage.createGraphics();
                // 计算居中位置
                int x = (width - height) / 2; // 当原图的高变成新图的宽时
                int y = (height - width) / 2; // 当原图的宽变成新图的高时
                
                // 将旋转后的图像居中绘制到原始尺寸的图像中
                g2dFinal.drawImage(tempRotated, x, y, Math.min(width, height), Math.min(width, height), null);
                g2dFinal.dispose();
                break;
            case 180:
                // 180度旋转，直接在原始尺寸内旋转
                rotatedImage = new BufferedImage(width, height, originalImage.getType());
                Graphics2D g2d180 = rotatedImage.createGraphics();
                g2d180.rotate(Math.PI, width / 2.0, height / 2.0); // 以图像中心为原点旋转180度
                g2d180.drawImage(originalImage, 0, 0, null);
                g2d180.dispose();
                break;
            default:
                throw new IllegalArgumentException("只支持90, 180, 270度旋转");
        }

        // 编码为JPEG字节数组
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(rotatedImage, "jpeg", outputStream);
        return outputStream.toByteArray();
    }


































































    /**
     * 0 字节差旋转：精准定位并修改 JPEG 字节流中的 EXIF Orientation 标记
     * @param jpegData 原始图片字节数组
     * @param degrees  旋转角度 (支持 90, 180, 270)
     * @return 修改后的字节数组，长度与原数组完全一致
     */
    public static byte[] rotateJpegLossless(byte[] jpegData, int degrees) {
        // 1. 将角度转换为 EXIF Orientation 常量
        // 1: 0°, 6: 顺时针90°, 3: 180°, 8: 逆时针90°
        int orientation;
        switch (degrees % 360) {
            case 90:  orientation = 6; break;
            case 180: orientation = 3; break;
            case 270:
            case -90: orientation = 8; break;
            default:  return jpegData;
        }

        byte[] data = Arrays.copyOf(jpegData, jpegData.length);

        // 2. 扫描 JPEG 标记，寻找 APP1 (0xFFE1) 区域
        int p = 0;
        while (p < data.length - 4) {
            if ((data[p] & 0xFF) == 0xFF && (data[p + 1] & 0xFF) == 0xE1) {
                modifyExifOrientation(data, p + 4, orientation);
                return data;
            }
            p++;
        }
        return data;
    }

    private static void modifyExifOrientation(byte[] data, int start, int orientation) {
        // 检查 EXIF 头部标识 "Exif\0\0"
        if (data[start] != 'E' || data[start+1] != 'x' || data[start+2] != 'i') return;

        // TIFF 头部起始位置 (Exif\0\0 之后)
        int tiffStart = start + 6;

        // 判断字节序: "II" (0x4949) 小端, "MM" (0x4D4D) 大端
        boolean isLittleEndian = (data[tiffStart] == 0x49);

        // 获取第一个 IFD 的偏移量 (通常是 8)
        int firstIfdOffset = readInt(data, tiffStart + 4, isLittleEndian);
        int entryPos = tiffStart + firstIfdOffset;

        // 读取 Entry 的数量
        int entryCount = readShort(data, entryPos, isLittleEndian);
        entryPos += 2;

        // 遍历所有 Entry 寻找 Tag 0x0112 (Orientation)
        for (int i = 0; i < entryCount; i++) {
            int tag = readShort(data, entryPos, isLittleEndian);
            if (tag == 0x0112) {
                // Entry 结构: Tag(2B), Type(2B), Count(4B), Value/Offset(4B)
                // 找到后，修改其 Value 部分
                writeInt16(data, entryPos + 8, orientation, isLittleEndian);
                return;
            }
            entryPos += 12; // 每个 Entry 固定 12 字节
        }
    }

    // --- 二进制辅助方法 ---
    private static int readShort(byte[] data, int offset, boolean isLE) {
        int b1 = data[offset] & 0xFF, b2 = data[offset + 1] & 0xFF;
        return isLE ? (b2 << 8 | b1) : (b1 << 8 | b2);
    }

    private static int readInt(byte[] data, int offset, boolean isLE) {
        int b1 = data[offset] & 0xFF, b2 = data[offset + 1] & 0xFF;
        int b3 = data[offset + 2] & 0xFF, b4 = data[offset + 3] & 0xFF;
        return isLE ? (b4 << 24 | b3 << 16 | b2 << 8 | b1) : (b1 << 24 | b2 << 16 | b3 << 8 | b4);
    }

    private static void writeInt16(byte[] data, int offset, int val, boolean isLE) {
        if (isLE) {
            data[offset] = (byte) (val & 0xFF);
            data[offset + 1] = (byte) ((val >> 8) & 0xFF);
        } else {
            data[offset] = (byte) ((val >> 8) & 0xFF);
            data[offset + 1] = (byte) (val & 0xFF);
        }
    }

}
