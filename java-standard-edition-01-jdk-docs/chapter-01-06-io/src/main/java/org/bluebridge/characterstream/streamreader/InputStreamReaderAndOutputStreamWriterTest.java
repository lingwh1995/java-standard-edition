package org.bluebridge.characterstream.streamreader;

import java.io.*;

/**
 * @author ronin
 */
public class InputStreamReaderAndOutputStreamWriterTest {
    public static void main(String[] args) throws FileNotFoundException {
        InputStreamReader inputStreamReader =
                new InputStreamReader(new FileInputStream("d:/inputstreamreader.txt"));
        OutputStreamWriter outputStreamWriter =
                new OutputStreamWriter( new FileOutputStream("d:/inputstreamwriter.txt"));
        int length = 0;
        char[] characters = new char[100];
        try {
            while((length = inputStreamReader.read(characters)) != -1){
                outputStreamWriter.write(characters,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(outputStreamWriter != null){
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
