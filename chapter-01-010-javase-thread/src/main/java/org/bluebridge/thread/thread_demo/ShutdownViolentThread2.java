package org.bluebridge.thread.thread_demo;

/**
 * @author ronin
 */
public class ShutdownViolentThread2 {
    public static void main(String[] args) {
        ThreadService service = new ThreadService();
        long start = System.currentTimeMillis();
        service.execute(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("load a very heavy resource......");
                }
            }
        });
        service.shutDown(3000);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
