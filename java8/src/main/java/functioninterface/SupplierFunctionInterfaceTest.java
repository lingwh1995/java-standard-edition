package functioninterface;

import java.util.function.Supplier;

/**
 * 不接收参数,并返回一个结果，在工厂中创建对象
 * @author ronin
 */
public class SupplierFunctionInterfaceTest {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello world!";
        System.out.println(supplier.get());

        Supplier<Person> p1 = () -> new Person();
        //构造方法引用
        Supplier<Person> p2 = Person::new;
        System.out.println(p1.get());
        System.out.println(p2.get());
    }
}
