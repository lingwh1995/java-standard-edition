package org.bluebridge.character_stream.array;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

/**
 * @author ronin
 */
public class CharArrayWriterTest {
    public static void main(String[] args) {
        String src = "Hello World!";
        CharArrayReader reader = new CharArrayReader(src.toCharArray());
        CharArrayWriter writer = new CharArrayWriter();
        int length = 0;
        char[] chars = new char[2];
        try {
            while((length = reader.read(chars))!=-1){
                writer.write(chars,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(reader!=null){
                reader.close();
            }
            if(writer!=null){
                writer.close();
            }
        }
        System.out.println("CharArrayWriter:"+writer.toString());
    }
}
