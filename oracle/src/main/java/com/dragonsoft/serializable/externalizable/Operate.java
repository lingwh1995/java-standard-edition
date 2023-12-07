package com.dragonsoft.serializable.externalizable;

import java.io.*;

/**
 * @author ronin
 */
public class Operate {
    /**
     * 序列化方法
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void serializable(Person person) throws FileNotFoundException, IOException {
        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("d:/a.txt"));
        outputStream.writeObject(person);
    }

    /**
     * 反序列化的方法
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public Person deSerializable() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("d:/a.txt"));
        return (Person) ois.readObject();
    }
}
