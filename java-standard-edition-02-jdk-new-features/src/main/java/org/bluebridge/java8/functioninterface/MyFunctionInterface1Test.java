package org.bluebridge.java8.functioninterface;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/25 8:54
 */
public class MyFunctionInterface1Test {

    public static void main(String[] args) {
        MyFunctionInterface1Test test = new MyFunctionInterface1Test();
        test.test(new MyFunctionInterface1() {
            @Override
            public void fun() {
                System.out.println("xxxx");
            }
        });
        System.out.println("------------------");
        test.test(()->{
            System.out.println("yyy");
        });
        System.out.println("------------------");
        MyFunctionInterface1 myInterface = ()->{
            System.out.println("zzz");
        };
        test.test(myInterface);
        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getCanonicalName());
        System.out.println(myInterface.getClass().getSuperclass());
    }

    public void test(MyFunctionInterface1 myInterface){
        System.out.println("1");
        myInterface.fun();
        System.out.println("2");
    }
}
