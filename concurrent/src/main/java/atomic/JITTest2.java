package atomic;

/**
 * 不使用volatile修饰init,在第一个线程的while代码块中加一句:System.out.println(init);
 * 当第二个线程将init的值设置为true后,第一个线程也停止运行了
 * 出现这个情况的原因是JIT的运行时优化
 *      非volatile修饰的boolean变量作为条件,如while循环体中没有代码,JIT会帮我们进行优化,终止该
 *      线程的执行,如果while循环体中有代码,则JIT不会帮我们结束该线程的运行
 *
 * @author ronin
 */
public class JITTest2 {
    private static boolean init = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while(!init){
                System.out.println(init);
            }
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            init = true;
            System.out.println("Set init to true!");
        }).start();
    }
}
