package org.bluebridge.basic;

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
}
