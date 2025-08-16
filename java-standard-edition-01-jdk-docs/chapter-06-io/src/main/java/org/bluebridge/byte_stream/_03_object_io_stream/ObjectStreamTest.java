package org.bluebridge.byte_stream._03_object_io_stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;

/**
 * @author lingwh
 * @desc ObjectStream 用于实现序列化和反序列化
 * @date 2025/8/16 13:39
 */
@Slf4j(topic = "·")
public class ObjectStreamTest {

    /**
     * 序列化基本类型数据
     */
    @Test
    public void testSerializableBasicData() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/objectstream.txt"));
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeDouble(0.5);
            objectOutputStream.writeUTF("&");
            //如果输出流不关闭,则会抛出:java.io.EOFException
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("d:/objectstream.txt"));
            System.out.println(objectInputStream.readBoolean());
            System.out.println(objectInputStream.readDouble());
            System.out.println(objectInputStream.readUTF());
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 序列化引用类型数据
     */
    @Test
    public void testSerializableReferenceData() {
        try {
            Employee harry = new Employee("Tom", 20000, 2015, 7, 10);
            Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
            carl.setSecretary(harry);
            Manager tony = new Manager("Tony Tester", 40000, 1990, 3, 15);
            tony.setSecretary(harry);
            Employee[] staff = new Employee[3];
            staff[0] = harry;
            staff[1] = carl;
            staff[2] = tony;
            String filePath = "d:/employee.dat";
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
            out.writeObject(staff);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));
            Employee[] employees = (Employee[]) in.readObject();
            for (Employee employee : employees) {
                log.info("employee: {}", employee);
            }
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
