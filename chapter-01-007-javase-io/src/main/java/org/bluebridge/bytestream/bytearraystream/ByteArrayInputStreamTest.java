package org.bluebridge.bytestream.bytearraystream;

import java.io.ByteArrayInputStream;

/**
 * 字节数组输入流:
 *      在内存中创建一个字节数组,将输入流中读取的数据保存到字节数组的缓冲区中
 * @author ronin
 */
public class ByteArrayInputStreamTest {
    public static void main(String[] args) {
        byte[] bytes = "abcdefghijklmnopqrst".getBytes();
        ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
        //avaiable表示剩余可字节数,除了a,还剩19个字节
        if(byteStream.available()>0) {
            System.out.println((char)byteStream.read()+"------剩余可读字节数="+byteStream.available());
        }
        for(int i  = 0 ; i < 3;i++) {
            if(byteStream.available()>0) {
                System.out.println((char)byteStream.read());
            }
        }
        //现在位置是d,跳过3个字节,下一个字节是h
        long skip = byteStream.skip(3);
        System.out.println((char)byteStream.read()+"-----跳过字节数="+skip);
        if(byteStream.markSupported()) {
            System.out.println("support mark");
        }
        //现在是位置在i,进行标记.
        byteStream.mark(0);
        //使用字节数组,一次性读取三个字节.
        byte[] byteArray = new byte[3];
        byteStream.read(byteArray, 0, 2);
        System.out.println(new String(byteArray));
        //通过reset()方法将指针指到到mark位置
        byteStream.reset();
        System.out.println((char)byteStream.read());
    }
}
