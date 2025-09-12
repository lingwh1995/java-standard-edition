package org.bluebridge._02_character_stream._07_print_writer;

/**
 * @author lingwh
 * @desc PrintWriter是Java IO包中的一个类，用于以格式化的方式打印各种数据类型的文本输出。它是 Writer 类的子类，提供了方便的打印方法。
 * @date 2025/9/12 17:02
 */

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.PrintWriter;

/**
 * PrintWriter 主要特点
 * 格式化输出：提供多种 print() 和 println() 方法
 * 自动刷新：可以选择在每次写操作后自动刷新输出
 * 异常处理：不会抛出 IOException，而是设置内部错误标志
 * 字符流：处理字符数据，适合文本输出
 */
@Slf4j(topic = "·")
public class PrintWriterTest {

    @Test
    public void testPrintWriter() {
        // 创建输出到控制台的PrintWriter
        PrintWriter pw = new PrintWriter(System.out, true);

        // 打印各种数据类型
        pw.println("Hello, World!");
        pw.println("Integer: " + 42);
        pw.println("Double: " + 3.14159);
        pw.println("Boolean: " + true);

        // 格式化输出
        pw.printf("Name: %s, Age: %d, Score: %.2f%n", "Alice", 25, 95.5);

        // 关闭流
        pw.close();
    }
}

//// 输出到文件
//public class PrintWriterFileExample {
//    public static void main(String[] args) {
//        try {
//            // 创建输出到文件的PrintWriter
//            PrintWriter pw = new PrintWriter("output.txt", "UTF-8");
//
//            // 写入数据
//            pw.println("=== 系统日志 ===");
//            pw.println("时间: " + new Date());
//            pw.println("用户: " + System.getProperty("user.name"));
//            pw.println("操作系统: " + System.getProperty("os.name"));
//
//            // 格式化输出
//            for (int i = 1; i <= 10; i++) {
//                pw.printf("记录 %d: 处理完成%n", i);
//            }
//
//            pw.println("=== 日志结束 ===");
//
//            // 关闭流
//            pw.close();
//
//            System.out.println("文件写入完成");
//        } catch (IOException e) {
//            System.err.println("文件操作错误: " + e.getMessage());
//        }
//    }
//}
//
////输出到字符串
//import java.io.*;
//
//public class PrintWriterStringExample {
//    public static void main(String[] args) {
//        // 使用 StringWriter 作为输出目标
//        StringWriter stringWriter = new StringWriter();
//        PrintWriter pw = new PrintWriter(stringWriter);
//
//        // 写入数据
//        pw.println("这是第一行");
//        pw.println("这是第二行");
//        pw.printf("数字: %d, 字符串: %s%n", 123, "测试");
//
//        // 获取结果字符串
//        String result = stringWriter.toString();
//        System.out.println("输出内容:");
//        System.out.println(result);
//
//        // 关闭流
//        pw.close();
//    }
//}
//
//// 与网络套接字一起使用
//public class PrintWriterSocketExample {
//    public static void main(String[] args) {
//        try {
//            // 创建服务器套接字
//            ServerSocket serverSocket = new ServerSocket(8080);
//            System.out.println("服务器启动，等待连接...");
//
//            // 接受客户端连接
//            Socket clientSocket = serverSocket.accept();
//            System.out.println("客户端已连接");
//
//            // 创建PrintWriter发送响应
//            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//
//            // 发送HTTP响应
//            out.println("HTTP/1.1 200 OK");
//            out.println("Content-Type: text/html; charset=utf-8");
//            out.println();
//            out.println("<html><body>");
//            out.println("<h1>Hello from PrintWriter Server!</h1>");
//            out.println("<p>当前时间: " + new java.util.Date() + "</p>");
//            out.println("</body></html>");
//
//            // 关闭资源
//            out.close();
//            clientSocket.close();
//            serverSocket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//// 错误处理示例
//public class PrintWriterErrorHandling {
//    public static void main(String[] args) {
//        try {
//            // 创建PrintWriter
//            PrintWriter pw = new PrintWriter("test.txt");
//
//            // 正常输出
//            pw.println("正常输出内容");
//            System.out.println("检查错误状态: " + pw.checkError());
//
//            // 强制关闭底层流来模拟错误
//            pw.close();
//
//            // 尝试在关闭后写入（会产生错误）
//            pw.println("这会产生错误");
//
//            // 检查是否有错误
//            if (pw.checkError()) {
//                System.out.println("检测到错误");
//            }
//
//            pw.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//最佳实践
//选择合适的构造方法：根据输出目标选择合适的构造方法
//及时关闭资源：使用 try-with-resources 语句确保资源被正确关闭
//合理使用自动刷新：对于实时输出场景启用自动刷新
//检查错误状态：定期使用 checkError() 方法检查是否有错误发生
//字符编码：指定正确的字符编码以避免乱码问题
//
//// 推荐的使用方式
//try (PrintWriter pw = new PrintWriter(new FileWriter("output.txt", "UTF-8"), true)) {
//        pw.println("Hello, World!");
//    pw.printf("Number: %d%n", 42);
//} catch (IOException e) {
//        System.err.println("文件操作失败: " + e.getMessage());
//        }