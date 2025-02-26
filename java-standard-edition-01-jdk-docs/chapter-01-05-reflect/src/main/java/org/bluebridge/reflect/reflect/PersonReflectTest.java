package org.bluebridge.reflect.reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.bluebridge.reflect.domain.Person;
import org.junit.Test;

/**
 * 测试反射操作Person类
 *      反射必调用被操作对象的无参构造方法
 */
public class PersonReflectTest {

    /**
     * 四种方式获得反射对象/Class类:反射必走无参(包括父类无参、子类无参)
     * @throws ClassNotFoundException
     */
    @Test
    public void testReflectGetJavaBeanClass() throws ClassNotFoundException{
        //方式1:该对象自身的.class属性
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        //方式2:根据运行时的类的对象
        Person person = new Person();
        Class<? extends Object> clazz2 = person.getClass();
        System.out.println(clazz2);
        //方式3:Class的静态方法获取:体现反射的动态性
        Class<? extends Object> clazz3 = Class.forName("org.bluebridge.reflect.domain.Person");
        System.out.println(clazz3);
        //方式4:通过类加载器获取
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class<? extends Object> clazz4 = classLoader.loadClass("org.bluebridge.reflect.domain.Person");
        System.out.println(clazz4);
    }

    /**
     * 测试反射调用无参构造方法创建对象
     * @throws Exception
     */
    @Test
    public void testReflectCreateInstanceByNoArgsConstructor () throws Exception{
        //1.获取class对象
        Class<? extends Object> clazz = getClass().forName("org.bluebridge.reflect.domain.Person");
        System.out.println("包名+类名:" + clazz.getName());
        System.out.println("类名:" + clazz.getSimpleName());
        //2.得到Person实例，反射操作无参构造方法
            //反射通过无参构造器实例化对象对象方式1:
        Person person1 = (Person)clazz.newInstance();
        System.out.println("person1:" + person1);
            //反射通过无参构造器实例化对象对象方式2:
        Person person2 = (Person)clazz.getDeclaredConstructor().newInstance();
        System.out.println("person2" + person2);
    }


    /**
     * 测试反射调用有参构造方法创建对象
     * @throws Exception
     */
    @Test
    public void testReflectCreateInstanceByRequiredArgsConstructor() throws Exception{
        //1.获取class对象
        Class<? extends Object> clazz = Class.forName("org.bluebridge.reflect.domain.Person");
        //2.使用class获取有参构造方法的构造器，注意：传入的参数类型为Class类型的
            //获取有参构造器方式1:直接传入两个参数的数据类型的class
        Person person1 = (Person)clazz.getDeclaredConstructor(String.class,String.class).newInstance("张三","18");
        System.out.println(person1);
        //获取有参构造器方式2:传入一个Class[]对象
        Person person2 = (Person)clazz.getDeclaredConstructor(new Class[]{String.class,String.class}).newInstance("李四","20");
        System.out.println(person2);
    }

    /**
     * 测试反射获取属性(私有/公有) + 为属性设置值
     * @throws Exception
     */
    @Test
    public void testReflectGetFieldInfoAndSetFieldInfo() throws Exception{
        //1.获取class对象
        Class clazz = Class.forName("org.bluebridge.reflect.domain.Person");
        //2.得到Person对象
        Person person = (Person)clazz.newInstance();
        //3.得到name属性
            //getDeclaredFields():得到所有的属性
        Field[] declaredFields = clazz.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));
            //获取单个属性
        Field nameField = clazz.getDeclaredField("name");
        System.out.println("name属性: " + nameField);

            //通过反射写入属性
        //设置可以操作私有属性
        nameField.setAccessible(true);
        //第一个参数:上面获取的类的实例 第二个参数:属性的具体值
        nameField.set(person, "我是你大爷");
        System.out.println(person);

            //通过反射读取属性
        String  name = (String)nameField.get(person);
        System.out.println("通过反射读取属性:"+name);
    }

    /**
     * 测试反射执行公有方法
     * @throws Exception
     */
    @Test
    public void testReflectInvokePublicMethod() throws Exception{
        //1.获取class对象
        Class clazz = Class.forName("org.bluebridge.reflect.domain.Person");
        //2.得到Person对象
        Person person = (Person)clazz.newInstance();
        //3.操作普通方法
        //两个参数:1.方法名		2.要执行的方法需要的参数的值，如下:setName("xxxxxxx");
        Method reflectOperator = clazz.getDeclaredMethod("setName", String.class);
        //4.使用反射执行该方法
        reflectOperator.invoke(person, "测试使用反射执行公有方法");
        System.out.println(person);
    }

    /**
     * 测试反射调用私有方法
     * @throws Exception
     */
    @Test
    public void testReflectInvokePrivateMethod() throws Exception{
        //1.获取class对象
        Class clazz = getClass().forName("org.bluebridge.reflect.domain.Person");
        //2.获取Person实例
        Person person = (Person)clazz.newInstance();
        //3.使用反射操作私有方法
        Method declaredMethod = clazz.getDeclaredMethod("drink", String.class);
        //4.设置可以操作私有方法
        declaredMethod.setAccessible(true);
        //5.使用反射操作该私有方法
        declaredMethod.invoke(person, "橙汁饮料...");
    }


    /**
     * 测试反射调用静态(私有)方法
     * @throws Exception
     */
    @Test
    public void testReflectInvokeStaticMethod() throws Exception{
        //1.获取class对象
        Class clazz = getClass().forName("org.bluebridge.reflect.domain.Person");
        //2.获取方法操作器
        Method declaredMethod = clazz.getDeclaredMethod("sleep", String.class);
        //3.设置可以操作私有方法
        declaredMethod.setAccessible(true);
        //4.使用反射操作该静态方法，注意：因为操作的方法是静态方法，所以不需要传入Person的实例对象
        Object invokeResult = declaredMethod.invoke(null, "席梦思床");
        System.out.println(invokeResult);
    }

    /**
     * 使用反射获取属性修饰符:public/private
     * @throws Exception
     */
    @Test
    public void testReflectGetPrivateMethod() throws Exception{
        //1.获取class对象
        Class clazz = getClass().forName("org.bluebridge.reflect.domain.Person");
        //2.获取属性
        Field nameFiled = clazz.getDeclaredField("name");
        //3.获取属性的修饰符
        int currentModifiyCode = nameFiled.getModifiers();
        System.out.println(currentModifiyCode);
    }

    /**
     * 获取class对象/构造器加强:直接可以获取到指定类型的Class对象和构造器，不用再强行转换了
     * @throws NoSuchMethodException
     */
    @Test
    public void testReflectCreateInstanceUseGeneric() throws NoSuchMethodException {
        //1.获取指定类型的Class对象
        Class<Person>  personClass = Person.class;
        //2.获取指定类型的构造器
        Constructor<Person> personConstructor = personClass.getConstructor();
        System.out.println("Person类型的无参构造器:"+personConstructor);
    }
}
