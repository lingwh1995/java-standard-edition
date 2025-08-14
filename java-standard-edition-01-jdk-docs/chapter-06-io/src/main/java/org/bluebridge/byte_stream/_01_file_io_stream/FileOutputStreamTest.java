package org.bluebridge.byte_stream._01_file_io_stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;

/**
 * @author lingwh
 * @desc FileOutputStream
 * @date 2025/8/14 17:28
 */
@Slf4j(topic = "·")
public class FileOutputStreamTest {

    /**
     * 将指定的字节写入此文件输出流
     *
     * public void write(int b) throws IOException;
     * @param_ b 要写入的字节
     */
    @Test
    public void testWriteByByte() {
        try(FileOutputStream fileOutputStream = new FileOutputStream("d:/fileoutputstream.txt")) {
            fileOutputStream.write(97);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 从偏移开始的指定字节数组写入 len 字节到此文件输出流。参数：b – 数据。off – 数据中的起始偏移量。len – 要写入的字节数。
     *
     * public void write(byte[] b, int off, int len) throws IOException;
     * @param_ b 数据
     * @param_ off 数据中的起始偏移量
     * @param_ len 要写入的字节数。
     */
    @Test
    public void testWriteByBytes() {
        try(
            FileInputStream fileInputStream = new FileInputStream(new File("d:/fileinputstream.txt"));
            FileOutputStream fileOutputStream = new FileOutputStream("d:/fileoutputstream.txt")
        ) {
//            FileDescriptor fd = fileOutputStream.getFD();
//            log.info("FileDescriptor：{}", fd);
            byte[] buffer = new byte[2];
            int length = 0;
            while((length=fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
