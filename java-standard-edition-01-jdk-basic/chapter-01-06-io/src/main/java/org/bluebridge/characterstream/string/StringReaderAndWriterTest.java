package org.bluebridge.characterstream.string;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * TT_EOF(流结尾)、
 * TT_EOL(行结尾)、
 * TT_NUMBER(数字符号, 0 1 2 3 4 5 6 7 8 9 . -都属于数字语法)、
 * TT_WORD(一个单词)
 * @author ronin
 */
public class StringReaderAndWriterTest {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args){
        String content = "我是蒋辉文！你是谁呢？";
        StringReader reader = new StringReader(content);
        StringWriter writer = new StringWriter();
        try {
            int length = 0;
            char[] buffer = new char[20];
            while((length = reader.read(buffer))!=-1){
                writer.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                reader.close();
            }
        }
        System.out.println("StringWriter中保存的读取到的数据:"+writer.toString());
    }

}
