package org.bluebridge.utils;

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
}
