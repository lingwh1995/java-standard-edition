package org.bluebridge.byte_stream.filterstream.pushbackinputstream;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * 缓存的新应用之一就是回推（pushback）的实现。回推用于输入流，以允许读取字节，然后再将它们返回（回推）到流中。
 * PushbackInputStream类实现了这一思想，提供了一种机制，可以“偷窥”来自输入流的内容而不对它们进行破坏
 * @author ronin
 * @version V1.0
 * @since 2019/9/25 16:19
 */
public class PushbackInputStreamTest {
    public static void main(String[] args) {
        //unread1();
        //unread2();
        unread3();
    }


    /**
     * PushbackInputStream pbin = new PushbackInputStream(in)
     * 这个构造函数创建的对象一次只能回推一个字节,如果回推超过一个字符,则会报
     *      java.io.IOException: Push back buffer is full这个异常
     */
    private static void unread1() {
        String dest = "Example on how to convert a String to an InputStream";
        ByteArrayInputStream in = new ByteArrayInputStream(dest.getBytes());
        PushbackInputStream pushbackInputStream = new PushbackInputStream(in);
        int result = 0;
        try {
            while((result = pushbackInputStream.read()) != -1){
                System.out.print((char)result);
                if('E' == result){
                    pushbackInputStream.unread('0');
                    /**
                     * 下面的代码报错
                     * java.io.IOException: Push back buffer is full
                     */
//                    for(int i=0;i<10;i++){
//                        pushbackInputStream.unread(0);
//                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(pushbackInputStream != null){
                try {
                    pushbackInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * PushbackInputStream pbin = new PushbackInputStream(in,n)
     * 这个构造函数创建的对象一次只能回推n个字节,如果回推超过n个字符,则会报
     *      java.io.IOException: Push back buffer is full这个异常
     */
    private static void unread2() {
        String dest = "Example on how to convert a String to an InputStream";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dest.getBytes());
        PushbackInputStream pushbackInputStream = new PushbackInputStream(byteArrayInputStream, 3);
        try {
            int n;
            byte[] buffer = new byte[3];
            while ((n = pushbackInputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer));
                if (new String(buffer).equals("Exa")) {
                    pushbackInputStream.unread(new byte[]{'M', 'N', 'O'});
                }
                buffer = new byte[3];
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pushbackInputStream != null) {
                try {
                    pushbackInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void unread3(){
        String dest = "abcdefg";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(dest.getBytes());
        PushbackInputStream pushbackInputStream = new PushbackInputStream(byteArrayInputStream,4);
        try {
            int n;
            byte[] buffer = new byte[4];
            while ((n = pushbackInputStream.read(buffer)) != -1) {
                System.out.println(new String(buffer));
                if(new String(buffer).equals("abcd")){
                    pushbackInputStream.unread(buffer,2,2);
                }
                //清空缓冲区
                buffer = new byte[4];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (pushbackInputStream != null) {
                try {
                    pushbackInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
