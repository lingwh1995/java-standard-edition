package com.dragonsoft.serializable.serializable;

import java.io.*;

/**
 * @author ronin
 */
public class SerializableTest2 {
    public static void main(String[] args) {
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            //序列化
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            Dog dog = new Dog("zs", 18, "swim");
            objectOutputStream.writeObject(dog);
            objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            Dog o = (Dog)objectInputStream.readObject();
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class Dog implements Serializable{

    private static final long serialVersionUID = -5561166375102770349L;
    private String name;
    private Integer age;
    private String hobby;

    /**
     * 加上这个方法,可以控制序列化哪些字段
     * @param objectOutputStream
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(name);
        objectOutputStream.writeObject(age);
    }

    /**
     * 加上这个方法,可以控制反序列化哪些字段
     * @param objectInputStream
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        name = (String)objectInputStream.readObject();
        age = (int)objectInputStream.readObject();
    }
    public Dog(String name, Integer age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
