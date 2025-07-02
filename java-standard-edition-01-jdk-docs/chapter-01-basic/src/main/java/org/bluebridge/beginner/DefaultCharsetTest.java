package org.bluebridge.beginner;

public class DefaultCharsetTest {
    public static void main(String[] args) {
        String charsetName = System.getProperty("file.encoding");
        System.out.println("Default Charset: " + charsetName);
    }

}
