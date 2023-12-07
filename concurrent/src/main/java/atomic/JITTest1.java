package atomic;

/**
 * 使用volatile修饰init,第二个线程修改init值为true后第一个线程也会停止运行
 * 注意:第一个线程while语句块中什么都不要写
 * @author ronin
 */
public class JITTest1 {
    /**保证内存可见性*/
    private volatile static boolean init = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while(!init){

            }
        }).start();
        Thread.sleep(1000);
        new Thread(()->{
            init = true;
            System.out.println("Set init to true!");
        }).start();
    }
}
