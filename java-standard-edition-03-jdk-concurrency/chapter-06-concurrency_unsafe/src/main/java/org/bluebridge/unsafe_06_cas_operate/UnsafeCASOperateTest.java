package org.bluebridge.unsafe_06_cas_operate;

/**
 * Unsafe应用五    CAS操作
 */
public class UnsafeCASOperateTest {

    public static void main(String[] args){
        Student student = new Student();
        new Thread(()->{
            for (int i = 1; i < 5; i++) {
                student.increment(i);
                System.out.print(student.age + " ");
            }
        }).start();

        new Thread(()->{
            for (int i = 5 ; i <10 ; i++) {
                student.increment(i);
                System.out.print(student.age + " ");
            }
        }).start();
    }
}
