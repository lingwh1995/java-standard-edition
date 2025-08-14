package org.bluebridge.byte_stream.sequenceinputstream;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 * 合并输入流/输入流的逻辑串联
 * @author ronin
 */
public class SequenceInputStreamTest {
    public static void main(String[] args) throws IOException {
        mergeInputStream1();
        //mergeInputStream2();
    }

    /**
     * 不借助枚举合并两个输入流,注意:这种方式只能合并两个输入流
     * @throws IOException
     */
    private static void mergeInputStream1() throws IOException {
        InputStream fis1 = new FileInputStream("d:/sequenceinputstream1.txt");
        InputStream fis2 = new FileInputStream("d:/sequenceinputstream2.txt");
        SequenceInputStream sis = new SequenceInputStream(fis1,fis2);

        //创建输出流---要把前三个文件的内容读出来并且合并到.txt;
        FileOutputStream fos = new FileOutputStream("d:/d.txt");
        int len=0;
        byte buf[] = new byte[10];
        while((len=sis.read(buf))!=-1){
            fos.write(buf, 0, len);
        }
        fos.close();
        sis.close();
    }
    /**
     * 借助枚举合并两个输入流
     * @throws IOException
     */
    private static void mergeInputStream2() throws IOException {
        InputStream fis1 = new FileInputStream("d:/sequenceinputstream1.txt");
        InputStream fis2 = new FileInputStream("d:/sequenceinputstream2.txt");
        InputStream fis3 = new FileInputStream("d:/sequenceinputstream3.txt");
        ArrayList<InputStream> c = new ArrayList<>();
        c.add(fis1);
        c.add(fis2);
        c.add(fis3);
        Enumeration<InputStream> e = Collections.enumeration(c);
        SequenceInputStream sis = new SequenceInputStream(e);

        //创建输出流---要把前三个文件的内容读出来并且合并到.txt;
        FileOutputStream fos = new FileOutputStream("d:/d.txt");
        int len=0;
        byte buf[] = new byte[10];
        while((len=sis.read(buf))!=-1){
            fos.write(buf, 0, len);
        }
        fos.close();
        sis.close();
    }
}
