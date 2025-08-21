package org.bluebridge.character_stream._01_io_stream_reader;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;

/**
 * @author lingwh
 * @desc 字符输出流
 * @date 2025/8/21 16:41
 */
@Slf4j(topic = "·")
public class OutputStreamWriterTest {

    @Test
    public void testInputStreamReader() throws FileNotFoundException {
        try(InputStreamReader isr = new InputStreamReader(new FileInputStream("d:/inputstreamreader.txt"));
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d:/outputstreamwriter.txt"))
        ) {
            // 10 + 2 = 每一行字节个数 + 2字节换行符 = 12
            char[] buffer = new char[12];
            int length = 0;
            while((length = isr.read(buffer)) != -1){
                log.info("本次读取到的长度：{}，读取到的内容： {}", length, new String(buffer,0, length));
                osw.write(buffer,0,length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
