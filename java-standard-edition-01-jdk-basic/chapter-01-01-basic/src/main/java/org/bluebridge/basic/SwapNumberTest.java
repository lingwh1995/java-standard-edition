package org.bluebridge.basic;

import org.junit.Test;

/**
 *  java中的值传递
 *  值传递: 就是把字面值复制一份作为实参传递给方法
 *  注意: 在C语言中有值传递和引用传递,引用传递就是指针传递
 */
public class SwapNumberTest {
	
	@Test
    public void testSwapNumber() {
        //测试交换失败
        int a = 1;
        int b = 2;
        swap_1(a,b);
        System.out.printf("a = %d, b = %d\n", a, b);

        //测试使用数组成功交换两个数字
        int c = 1;
        int d = 2;
        int[] arr = {c,d};
        swap_2(arr);
        System.out.printf("c = %d, d = %d\n", arr[0], arr[1]);

        //测试使用泛型数组成功交换两个数字
        int e = 1;
        int f = 2;
        int[] arr_t = {e,f};
        swap_2(arr_t);
        System.out.printf("e = %d, f = %d\n", arr_t[0], arr_t[1]);
    }

    /**
     * 无法交换成功
     * @param a
     * @param b
     */
    public static void swap_1(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

    /**
     * 使用数组实现交换两个数
     *      注意: 此处可以直接返回数组,也可以不返回数组
     * @param arr
     */
    public static void swap_2(int[] arr) {
        arr[0] = arr[0] ^ arr[1];
        arr[1] = arr[0] ^ arr[1];
        arr[0] = arr[0] ^ arr[1];
    }

    /**
     * 使用泛型数组实现交换两个数
     * @param arr
     */
    public static <T> T[] swap_2(T[] arr) {
        T temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
        return arr;
    }
}


