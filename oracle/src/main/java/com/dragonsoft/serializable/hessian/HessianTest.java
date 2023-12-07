package com.dragonsoft.serializable.hessian;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author ronin
 */
public class HessianTest {
    public static void main(String[] args) {
        Person person = new Person("zs", "123456","35");
        byte[] serialize = serialize(person);
        Person deserialize = (Person)deserialize(serialize);
        System.out.println(deserialize);
    }

    public static <T> byte[] serialize(T obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        HessianOutput hessianOutput = new HessianOutput(bos);
        try {
            //obj必须实现Serializable接口
            hessianOutput.writeObject(obj);
            bytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public static <T> T deserialize(byte[] data) {
        if (data == null) {
            return null;
        }
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        HessianInput hessianInput = new HessianInput(bis);
        Object object = null;
        try {
            object = hessianInput.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (T)object;
    }
}
