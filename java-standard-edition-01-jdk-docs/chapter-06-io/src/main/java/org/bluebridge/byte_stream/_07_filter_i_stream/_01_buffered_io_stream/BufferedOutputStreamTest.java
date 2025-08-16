package org.bluebridge.byte_stream._07_filter_i_stream._01_buffered_io_stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;

/**
 * @author lingwh
 * @desc BufferedOutputStream 带有缓冲区的字节输出流，默认大小是8m，可以通过减少访问磁盘的次数来提高文件写入性能
 * @date 2025/8/16 17:16
 */
@Slf4j(topic = "·")
public class BufferedOutputStreamTest {

    @Test
    public void testBufferedOutputStreamWrite() {
        try(OutputStream os = new FileOutputStream(new File("d:/bufferedoutputstream.txt"));
            // 设置缓冲区大小为2个字节
            OutputStream bos = new BufferedOutputStream(os, 2)) {
            String data = "helloworld!";
            bos.write(data.getBytes());
            // 刷新缓冲区，确保数据写入文件
            bos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            log.info("写入文件完成......");
        }
    }

}
