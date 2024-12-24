package org.bluebridge.beginner;


import static java.lang.Math.pow;

/**
 * 静态导入:导入到类级别,要求导入的方法必须是静态方法
 * @author ronin
 */
public class StaticImport {
    public static void main(String[] args) {
        double pow = pow(0.2, 0.3);
        System.out.println(pow);
    }
}
