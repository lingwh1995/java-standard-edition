package org.bluebridge.character_stream._03_filter_reader_writer._02_filter_writer;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;

/**
 * @author lingwh
 * @desc
 * @date 2025/8/29 13:59
 */
@Slf4j(topic = "·")
public class LineNumberWriterTest {

    @Test
    public void testLineNumberWriter() {
        try {
            // 示例1: 基本使用
            StringWriter stringWriter = new StringWriter();
            LineNumberWriter lineNumberWriter = new LineNumberWriter(stringWriter);

            lineNumberWriter.write("第一行文本\n");
            lineNumberWriter.write("第二行文本\n");
            lineNumberWriter.write("第三行文本");

            lineNumberWriter.flush();
            log.info("输出结果:");
            System.out.println(stringWriter.toString());

            // 示例2: 与文件写入结合使用
            FileWriter fw = new FileWriter("d:/line_number_writer.txt");
            LineNumberWriter lnw = new LineNumberWriter(fw);

            // 设置行号宽度
            lnw.setNumberWidth(3);

            lnw.write("这是文件中的第一行\n");
            lnw.write("这是文件中的第二行\n");
            lnw.write("这是文件中的第三行\n");
            lnw.write("最后一行没有换行符");

            lnw.close();
            log.info("文件写入完成，内容如下:");

            // 读取并显示文件内容
            BufferedReader reader = new BufferedReader(new FileReader("d:/line_number_writer.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                log.info("line： {}", line);
            }
            reader.close();

            // 示例3: 与BufferedWriter结合使用提高性能
            fw = new FileWriter("d:/buffered_line_number_writer.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            LineNumberWriter blnw = new LineNumberWriter(bw);

            for (int i = 1; i <= 10; i++) {
                blnw.write("这是第" + i + "行文本\n");
            }

            blnw.close(); // 关闭最外层的writer即可
            log.info("带缓冲的行号写入完成");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
