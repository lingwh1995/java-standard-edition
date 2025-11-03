package org.bluebridge.utils;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

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
     * 旋转JPEG图片90度（逆时针）
     * @param jpegData 原始JPEG图片字节数组
     * @return 旋转后的JPEG图片字节数组
     * @throws IOException 如果图片解码或编码失败
     */
    public static byte[] rotateJpeg90Degrees(byte[] jpegData) throws IOException {
        // 解码JPEG图片
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(jpegData));
        // 计算旋转后的尺寸（宽高互换）
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        // 创建旋转变换（90度逆时针）
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(0, width);  // 调整平移参数
        affineTransform.rotate(-Math.PI / 2);  // 使用负角度实现逆时针旋转

        // 应用旋转
        AffineTransformOp op = new AffineTransformOp(affineTransform, AffineTransformOp.TYPE_BILINEAR);
        BufferedImage rotatedImage = op.filter(originalImage, new BufferedImage(height, width, originalImage.getType()));

        // 编码为JPEG字节数组
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(rotatedImage, "jpeg", outputStream);
        return outputStream.toByteArray();
    }

}
