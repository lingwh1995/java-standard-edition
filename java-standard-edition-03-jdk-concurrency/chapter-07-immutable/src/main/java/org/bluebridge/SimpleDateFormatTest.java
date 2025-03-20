package org.bluebridge;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * SimpleDateFormat.parse()线程安全问题以及解决
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 测试多线程情况下 sdf.parse()
        for (int i=0; i<100; i++) {
            new Thread(() -> {
                try {
                    System.out.println("parse = " + sdf.parse("1995-09-17"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        //使用 synchronized 解决线程安全问题
        for (int i=0; i<100; i++) {
            new Thread(() -> {
                synchronized (sdf) {
                    try {
                        System.out.println("parse = " + sdf.parse("1995-09-17"));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
    }
}
