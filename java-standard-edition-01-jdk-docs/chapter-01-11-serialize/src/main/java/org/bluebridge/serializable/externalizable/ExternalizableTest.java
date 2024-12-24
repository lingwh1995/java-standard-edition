package org.bluebridge.serializable.externalizable;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author ronin
 */
public class ExternalizableTest {

	/**
	 * 测试使用Externalizable接口实现序列化
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void testExternalizable() throws FileNotFoundException, IOException, ClassNotFoundException {
        ExternalizableUtils externalizableUtils = new ExternalizableUtils();
        //原始数据
        Person person = new Person("煤球","123456","20");
        System.out.println("为序列化之前的相关数据如下:\n" + person.toString());
        //执行序列化
        externalizableUtils.serializable(person);
        //执行反序列化
        Person newPerson = externalizableUtils.deSerializable();
        System.out.println("-------------------------------------------------------");
        System.out.println("反序列化之后的相关数据如下:\n" + newPerson.toString());
	}
}
