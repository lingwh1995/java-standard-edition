package org.bluebridge.bytestream.filterstream.bufferedstream;

import java.io.*;

/**
 * BufferedInputStream是带有缓冲区的字节输入流,默认大小是8M，能够提高
 * 文件读取性能，减少访问磁盘的次数
 *
 * @author ronin
 * @version V1.0
 * @since 2019/9/25 13:37
 */
public class BufferedInputStreamTest {
    public static void main(String[] args) {
        read();
        makeAndReset();
    }

    private static void read() {
        File file = new File("d:/bufferedinputstream.txt");
        InputStream bufferedInputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[1024];
            int length = 0;
            StringBuilder builder = new StringBuilder();
            while((length = bufferedInputStream.read(buffer)) != -1){
                builder.append(new String(buffer,0,length));
            }
            System.out.println(builder);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 测试make()方法和reset()
     * mark后读取多少字节才失效，并不完全由readlimit参数确定，也和BufferedInputStream类的缓冲区
     * 大小有关。 如果BufferedInputStream类的缓冲区大小大于readlimit，在mark以后只有读取超过缓
     * 冲区大小的数据，mark标记才会失效。
     */
    public static void makeAndReset() {
        InputStream bufferedInputStream = null;
        try {
            //设置缓冲区大小为2个字节
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File("d:/bufferedinputstream.txt")),2);
            System.out.println(bufferedInputStream.markSupported());
            System.out.println((char)bufferedInputStream.read());
            //设置readlimit为1,调用reset()会报错
            //bufferedInputStream.mark(1);
            //设置readlimit为5,调用reset()不会报错
            bufferedInputStream.mark(5);
            //标记位置之后再次读取四个字节
            bufferedInputStream.read(new byte[4],0,4);
            bufferedInputStream.reset();
            System.out.println((char)bufferedInputStream.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedInputStream != null){
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
