package org.bluebridge.character_stream._02_file_reader_writer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;

/**
 * @author lingwh
 * @desc 文件字符输出流（只能用于写出文件，使用系统默认字符编码，无法指定编码格式）
 * @date 2025/8/21 17:57
 */
@Slf4j(topic = "·")
public class FileWriterTest {

    @Test
    public void testInputStreamReader() throws IOException {
        try(FileReader fr = new FileReader("d:/filereader.txt");
            FileWriter fw = new FileWriter("d:/filewriter.txt")){
            // 10 + 2 = 每一行字节个数 + 2字节换行符 = 12
            char[] buffer = new char[12];
            int length = 0;
            while((length = fr.read(buffer)) != -1){
                log.info("本次读取到的长度：{}，读取到的内容： {}", length, new String(buffer,0, length));
                fw.write(buffer,0,length);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
