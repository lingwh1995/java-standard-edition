package org.bluebridge.characterstream.buffered;

import java.io.*;

/**
 * @author ronin
 */
public class BuffereredReaderAndWriterTest {
    public static void main(String[] args) {
        //测试readLine()和flush()方法
        //readLineAndFlush();
        //按字节读取
        readByByte();
    }

    /**
     * 测试readLine()和flush()方法
     */
    private static void readLineAndFlush() {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader("d:/bufferedreader.txt"));
            writer = new BufferedWriter(new FileWriter("d:/bufferedwriter.txt"));
            String line= null;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            //调用了flush()方法,程序不会暂停三秒才输出
            writer.flush();
            Thread.sleep(3000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 按字节数组读取
     */
    private static void readByByte() {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader("d:/bufferedreader.txt"));
            writer = new BufferedWriter(new FileWriter("d:/bufferedwriter.txt"));
            String line= null;
            char[] buffer = new char[100];
            int length = 0;
            while ((length = reader.read(buffer))!=-1) {
                writer.write(buffer,0,length);
            }
            //调用了flush()方法,程序不会暂停三秒才输出
            writer.flush();
            Thread.sleep(3000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
