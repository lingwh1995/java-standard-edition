package com.dragonsoft.optimization;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/10 17:23
 */
public class ForeachOptimization {
    public static void main(String[] args) {
        String s = "Hello,My friend,my name is zhangsan!";
        //不优化的写法
        for(int i=0;i<s.length();i++){
            System.out.println(s.charAt(i));
        }
        //优化的写法
        for(int i=0, length = s.length();i<length;i++){
            System.out.println(s.charAt(i));
        }
    }
}
