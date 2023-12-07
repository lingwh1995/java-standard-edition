package com.dragonsoft.serializable.serializable;

import java.io.*;

/**
 * @author ronin
 */
public class StaticVaribleSerializableTest implements Serializable{
    private static final long serialVersionUID = 1L;

    public static int staticVar = 5;

    public static void main(String[] args) {
        try {
            //初始时staticVar为5
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            out.writeObject(new StaticVaribleSerializableTest());
            out.close();

            //序列化后修改为10
            StaticVaribleSerializableTest.staticVar = 10;

            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                    "result.obj"));
            StaticVaribleSerializableTest t = (StaticVaribleSerializableTest) oin.readObject();
            oin.close();

            //再读取，通过t.staticVar打印新的值,打印的值为10，说明被static修饰的变量并不会参与序列化
            System.out.println(t.staticVar);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
