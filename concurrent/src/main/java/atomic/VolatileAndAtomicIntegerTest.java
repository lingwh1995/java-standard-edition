package atomic;
import	java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile关键字:
 *  1.保证重排序的时候不会把后面的指令放在屏障的前面，也不会把前面的放到后面
 *  2.强制对外缓存的修改操作立即写入到主存
 *  3.如果是写操作，会导致其他CPU中的缓存失效
 *  注意:并不能保证原子性
 *  AtomicInteger:
 *      可以保证可见性、有序性、原子性
 * 使用场景:
 *  1.状态量的标记
 *  2.屏障前后的一致性
 * @author ronin
 */
public class VolatileAndAtomicIntegerTest {
    private static AtomicInteger initValue = new AtomicInteger();
    //private volatile static int INIT_VALUE = 0;
    private final static int MAX_LIMIT = 50;
    public static void main(String[] args) {
        new Thread(()->{
            while (initValue.get() < MAX_LIMIT){
                System.out.println("T1->:"+(initValue.getAndIncrement()));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"ADDER-1").start();

        new Thread(()->{
            while (initValue.get() < MAX_LIMIT){
                System.out.println("T2->:"+(initValue.getAndIncrement()));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"ADDER-2").start();
    }
}
