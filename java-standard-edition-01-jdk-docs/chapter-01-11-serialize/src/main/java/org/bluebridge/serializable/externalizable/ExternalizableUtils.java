package org.bluebridge.serializable.externalizable;

import java.io.*;

/**
 * @author ronin
 */
public class ExternalizableUtils {
    /**
     * 序列化方法
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void serializable(Person person) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/data"));
        oos.writeObject(person);
        oos.close();
    }

    /**
     * 反序列化的方法
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public Person deSerializable() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/data"));
        return (Person) ois.readObject();
    }
}
