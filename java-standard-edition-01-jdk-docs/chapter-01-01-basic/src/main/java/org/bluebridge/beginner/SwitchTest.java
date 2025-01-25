package org.bluebridge.beginner;

import org.junit.Test;

/**
 * 1.switch可以进行嵌套
 * 2.switch中的case:后面的代码，可以使用{}括起来
 */
public class SwitchTest {

    /**
     * 测试switch的嵌套
     */
    @Test
    public void testSwitchNest() {
        char condition1 = '3';
        char condition2 = 'a';
        switch (condition1) {
            case '1':
                System.out.println("1");
                break;
            case '2':
                System.out.println("2");
                break;
            case '3':
                System.out.println("3");
                switch (condition2) {
                    case 'a':
                        System.out.println("a");
                        break;
                    case 'b':
                        System.out.println("b");
                        break;
                    case 'c':
                        System.out.println("c");
                        break;
                    default:
                        System.out.println("z");
                        break;
                }
                break;
            default:
                System.out.println(0);
                break;
        }
    }

    /**
     * 测试switch配合枚举使用
     */
    @Test
    public void testSwitchEnum() {
        Color color = Color.RED;
        switch (color) {
            case RED:
                System.out.println("红色...");
                break;
            case GREEN:
                System.out.println("绿色...");
                break;
            case BLUE:
                System.out.println("蓝色...");
                break;
            default:
                System.out.println("暂无该颜色...");
                break;
        }
    }

    /**
     * 测试case穿透
     */
    @Test
    public void testCasePenetrate() {
        int i = 0;
        switch (i) {
            case 0:
            case 1:
            case 2:
                System.out.println("测试case穿透...");
                break;
            case 3:
                System.out.println("i的值是3...");
                break;
            default:
                break;
        }
    }
}

enum Color {
    RED,GREEN,BLUE
}