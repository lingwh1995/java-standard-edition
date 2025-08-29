package org.bluebridge.character_stream._02_buffered_reader_writer._01_buffered_reader_writer;

/**
 * @author lingwh
 * @desc 带有缓冲区的输出流（通过缓冲字符来提高字符输出效率，特别适合输出大量文本数据）
 * @date 2025/8/29 9:54
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferedWriter主要特点
 *    缓冲机制: 内部使用缓冲区减少实际的写出操作次数
 *    行读取支持: 提供高效的按行写出方法
 *    性能优化: 比直接写出字符流更高效
 *    字符流操作: 专门用于处理字符数据而非字节数据
 * 最佳实践
 *    始终关闭资源: 使用 try-with-resources 或确保在 finally 块中关闭 BufferedWriter
 *    合适的缓冲区大小: 根据数据特征选择合适的缓冲区大小，默认通常是8192字符
 *    优先使用 writeLine(): 处理文本行时优先使用 writeLine() 而非逐字符写出
 *    异常处理: 妥善处理 IOException 异常、
 *
 * BufferedWriter 是处理文本数据时非常重要的类，通过缓冲机制显著提高了文本写出的性能，特别是在处理大量文本数据时效果明显。
 */
public class BufferedWriterTest {

    public void testBufferedWriter() {
        // 使用try-with-resources语法，自动关闭资源
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("buffered_writer.txt"))) {
            writer.write("Hello, BufferedWriter!");
            writer.newLine();
            writer.write("这是第二行内容");
            System.out.println("数据写入完成");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
