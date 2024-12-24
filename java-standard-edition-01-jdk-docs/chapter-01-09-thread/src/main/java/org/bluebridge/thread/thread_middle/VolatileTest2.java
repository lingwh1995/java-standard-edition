package org.bluebridge.thread.thread_middle;

/**
 * volatile关键字:
 *  1.保证重排序的时候不会把后面的指令放在屏障的前面，也不会把前面的放到后面
 *  2.强制对外缓存的修改操作立即写入到主存
 *  3.如果是写操作，会导致其他CPU中的缓存失效
 *  注意:并不能保证原子性
 * 使用场景:
 *  1.状态量的标记
 *  2.屏障前后的一致性
 * @author ronin
 */
public class VolatileTest2 {
    private volatile static int INIT_VALUE = 0;
    private final static int MAX_LIMIT = 50;

    public static void main(String[] args) {
        new Thread(()->{
            while (INIT_VALUE < MAX_LIMIT){
                System.out.println("T1->:"+(++INIT_VALUE));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"ADDER-1").start();

        new Thread(()->{
            while (INIT_VALUE < MAX_LIMIT){
                System.out.println("T2->:"+(++INIT_VALUE));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"ADDER-2").start();
    }
}
