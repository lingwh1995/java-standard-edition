package org.bluebridge.lang3;

import lombok.Data;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

import java.io.Serializable;

/**
 * 序列化工具类
 * @author ronin
 * @version V1.0
 * @desc
 * @since 2019/7/26 16:31 、2025/6/30 再次修改
 */
public class SerializationUtilsTest {

    @Test
    public void testSerializationUtils(){
        Person zhangsan = new Person("zhangsan", "28");
        byte[] serialize = SerializationUtils.serialize(zhangsan);
        System.out.println(serialize);
        Person deserialize = (Person) SerializationUtils.deserialize(serialize);
        System.out.println(deserialize);
    }

    @Data
    private static class Person implements Serializable{
        private static final long serialVersionUID = 1L;

        private String name;
        private String age;

        public Person(String name, String age) {
            this.name = name;
            this.age = age;
        }

    }

}
