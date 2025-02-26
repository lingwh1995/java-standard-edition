package org.bluebridge.bytestream.filestream;

import java.io.*;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/25 11:19
 */
public class FileOutputStreamTest {
    public static void main(String[] args) {
        //write();
        writeByByte();
    }

    /**
     * write(int b)
     */
    private static void write() {
        File file = new File("d:/fileoutputstream.txt");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(97);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * write(byte[] b)
     */
    private static void writeByByte() {
        InputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("d:/fileinputstream.txt"));
            fileOutputStream = new FileOutputStream(new File("d:/fileoutputstream.txt"));
            FileDescriptor fd = fileOutputStream.getFD();
            System.out.println("FileDescriptor:"+fd);
//            fileOutputStream.write(dest.getBytes());
            byte[] buffer = new byte[1];
            int length = 0;
            while((length=fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
