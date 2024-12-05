package org.bluebridge.basic;

import java.util.Scanner;

/**
 * 1.switch可以进行嵌套
 * 2.switch中的case:后面的代码，可以使用{}括起来
 */
public class SwitchTest {
    public static void main(String[] args) {
        switchTest1();
        //switchTest2();
    }

    /**
     * switch的嵌套
     */
    private static void switchTest1() {
        System.out.println("请输入:");
        Scanner scanner = new Scanner(System.in);
        char input_1 = scanner.nextLine().charAt(0);
        char input_2 = scanner.nextLine().charAt(0);
        switch (input_1) {
            case '1':
                System.out.println("1");
                break;
            case '2':
                System.out.println("2");
                break;
            case '3':
                System.out.println("3");
                switch (input_2) {
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


    private static void switchTest2() {
        System.out.println("请输入：");
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String input1 = null;
        String input2 = null;
        char key = ' ';
        boolean isLoop = true;
        while (isLoop) {
            key = in.nextLine().charAt(0);
            switch(key){
                case '1':
                    input1 = in.nextLine();
                    break;
                case '2':
                    input2 = in.nextLine();
                    break;
                default:
                    isLoop = false;
                    break;
            }
        }
        System.out.println("input1:"+input1);
        System.out.println("input2:"+input2);
        //ABCabc
        int count = 0;
        for(int i=0; i<input1.length(); i++){
            if(input2.equals(input1.charAt(i))){
                count++;
            }
        }
        System.out.println(count);
    }
}
