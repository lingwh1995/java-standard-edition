package org.bluebridge.api;

import org.junit.jupiter.api.Test;

/**
 * 二维数组测试
 */
public class TwoDimensionalArrayTest {

    @Test
    public void twoDimensionalArrayTest() {
        // 声明一个二维数组
        int[][] twoDimensionalArray1;

        // 初始化二维数组
        twoDimensionalArray1 = new int[3][4]; // 创建一个3行4列的二维数组

        // 声明并初始化二维数组方式一
        int[][] twoDimensionalArray2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // 声明并初始化二维数组方式二
        int[][] twoDimensionalArray3 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

    }
}
