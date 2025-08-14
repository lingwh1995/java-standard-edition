package org.bluebridge.byte_stream.filterstream.bufferedstream;

import java.io.*;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/25 14:41
 */
public class BufferedOutputStreamTest {
    public static void main(String[] args) {
        write();
    }
    private static void write(){
        String data = "helloworld!";
        OutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File("d:/bufferedoutputstream.txt")));
            byte[] buffer = new byte[1024];
            bufferedOutputStream.write(data.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedOutputStream != null){
                try {
                    bufferedOutputStream.close();
                    System.out.println("写入文件完成......");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
