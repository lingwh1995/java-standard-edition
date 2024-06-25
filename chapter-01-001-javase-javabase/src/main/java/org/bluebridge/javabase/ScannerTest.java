package org.bluebridge.javabase;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");

        //scanner.next() 输入 你 好，输出 你，不能获取用户输入的空格
//        if(scanner.hasNext()){
//            String input = scanner.next();
//            System.out.println(input);
//        }

        //scanner.next() 输入 你 好，输出 你好，可以获取用户输入的空格
//        if(scanner.hasNextLine()){
//            String input = scanner.nextLine();
//            System.out.println(input);
//        }

        //scanner.hasNextXXX()的作用：外层不调用scanner.hasNextInt(),内层直接调用scanner.nextInt();
        // 如果输入了浮点类型数据，则会直接抛出java.util.InputMismatchException异常
        if(scanner.hasNextInt()){
            int input1 = scanner.nextInt();
            int input2 = scanner.nextInt();
            System.out.println(input1);
            System.out.println(input2);
        }
        scanner.close();
    }
}


