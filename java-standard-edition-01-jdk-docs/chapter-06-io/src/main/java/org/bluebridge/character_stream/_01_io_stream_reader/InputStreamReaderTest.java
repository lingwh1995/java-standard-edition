package org.bluebridge.character_stream._01_io_stream_reader;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;

/**
 * @author lingwh
 * @desc 字符输入流（字节流到字符流的桥梁，可以将字节流转换为字符流，可以指定字符编码格式）
 * @date 2025/8/21 16:40
 */
@Slf4j(topic = "·")
public class InputStreamReaderTest {

    @Test
    public void testInputStreamReader() throws FileNotFoundException {
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream("d:/inputstreamreader.txt"))) {
            // 10 + 2 = 每一行字节个数 + 2字节换行符 = 12
            char[] buffer = new char[12];
            int length = 0;
            while((length = isr.read(buffer)) != -1){
                log.info("本次读取到的长度：{}，读取到的内容： {}", length, new String(buffer,0, length));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
