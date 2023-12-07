package org.bluebridge.bytestream.objectstream;

import java.io.*;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/25 17:21
 */
public class ObjectStreamTest {
    public static void main(String[] args) {
        serializableReferenceData();
        //serializableBasicData();
    }

    /**
     * 序列化基本类型数据
     */
    private static void serializableBasicData() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("d:/objectstream.txt"));
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeDouble(0.5);
            objectOutputStream.writeUTF("&");
            //如果输出流不关闭,则会抛出:java.io.EOFException
            //objectOutputStream.close();

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
    private static void serializableReferenceData() {
        Employee harry = new Employee("Tom", 20000, 2015, 7, 10);
        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        carl.setSecretary(harry);
        Manager tony = new Manager("Tony Tester", 40000, 1990, 3, 15);
        tony.setSecretary(harry);
        Employee[] staff = new Employee[3];
        staff[0] = harry;
        staff[1] = carl;
        staff[2] = tony;
        try {
            String filePath = "d:/employee.dat";
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
            out.writeObject(staff);
            out.close();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));
            Employee[] newStaff = (Employee[]) in.readObject();
            for (Employee employee : newStaff) {
                System.out.println(employee);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
