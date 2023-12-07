package functioninterface;

/**
 * @author ronin
 */
public class MyFunctionInteface2Impl implements MyFunctionInteface2,MyFunctionInteface3{

    /**
     * MyFunctionInteface2和MyFunctionInteface3都有method这个默认方法,
     * 使用:  接口名.super.方法名 来确定选择哪一个接口中的方法
     */
    @Override
    public void method() {
        MyFunctionInteface2.super.method();
    }


}
