package org.bluebridge.bytestream.filestream;

import java.io.*;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/25 9:07
 */
public class FileInputStreamTest {
    public static void main(String[] args) {
        //read();
        //readByByte();
    }

    /**
     * 每次读取的长度为byte数组的长度
     * read(byte[] b):返回读取到的数据的长度
     *
     */
    private static void readByByte() {
        File file = new File("d:/fileinputstream.txt");
        if(!file.exists()){
            return;
        }
        InputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[2];
//          int firstReadResult = fileInputStream.read(bytes);
//          System.out.println("第一次读取结果 长度:"+ firstReadResult+",值:"+new String(bytes,0,firstReadResult));
//          int secondReadResult = fileInputStream.read(bytes);
//          System.out.println("第二次读取结果 长度:"+secondReadResult+",值:"+new String(bytes,0,firstReadResult));
            byte[] buffer = new byte[4];
            int length = 0;
            StringBuilder builder = new StringBuilder();
            while((length = fileInputStream.read(buffer)) != -1){
                builder.append(new String(buffer,0,length));
            }
            System.out.println(builder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null ){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 一个字节一个字节的读取
     * int read():返回的是读取到的字节
     */
    private static void read() {
        File file = new File("d:/fileinputstream.txt");
        if(!file.exists()){
            return;
        }
        InputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
//            int firstReadResult = fileInputStream.read();
//            int secondReadResult = fileInputStream.read();
//            System.out.println("第一次读取结果:"+ firstReadResult+"("+(char)firstReadResult+")");
//            System.out.println("第二次读取结果:"+secondReadResult+"("+(char)secondReadResult+")");
            StringBuilder builder = new StringBuilder();
            int result = 0;
            while((result = fileInputStream.read()) != -1){
                builder.append((char)result);
            }
            System.out.println(builder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream !=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
