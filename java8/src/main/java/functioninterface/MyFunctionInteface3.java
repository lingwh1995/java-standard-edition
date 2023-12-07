package functioninterface;

/**
 * 测试被default修饰的方法
 * @author ronin
 */
public interface MyFunctionInteface3 {
    default void method(){
        System.out.println("method......MyFunctionInteface3");
    }
}
