package org.bluebridge.bytestream.filterstream.datastream;

import java.io.*;

/**
 * DataInputStream数据输入流允许应用程序以机器无关的方式从底层输入流中读取基本的Java类型
 * @author ronin
 * @version V1.0
 * @since 2019/9/25 15:54
 */
public class DataInputStreamTest {
    public static void main(String[] args) {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("d:/dataoutputstream.txt"));
            dos.writeUTF("α");
            dos.writeInt(1234567);
            dos.writeBoolean(true);
            dos.writeShort((short)123);
            dos.writeLong((long)456);
            dos.writeDouble(99.98);
            DataInputStream dis = new DataInputStream(new FileInputStream("d:/dataoutputstream.txt"));
            System.out.println(dis.readUTF());
            System.out.println(dis.readInt());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readShort());
            System.out.println(dis.readLong());
            System.out.println(dis.readDouble());
            dis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dos != null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
