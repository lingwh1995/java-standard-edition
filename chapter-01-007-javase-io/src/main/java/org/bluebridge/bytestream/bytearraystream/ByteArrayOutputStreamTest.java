package org.bluebridge.bytestream.bytearraystream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author ronin
 */
public class ByteArrayOutputStreamTest {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream bOutput = new ByteArrayOutputStream(12);
        bOutput.write("hello world!".getBytes());
        byte[] bytes = bOutput.toByteArray();
        System.out.println(new String(bytes));
    }
}
