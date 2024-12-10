package org.bluebridge.thread.thread_start;

/**
 * @author ronin
 */
public class DeamonTest {
    public static void main(String[] args) {
        Thread main = new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("main");
                }

                //守护线程
                Thread deamon = new Thread(){
                    @Override
                    public void run() {
                        while (true) {
                            System.out.println("deamon");
                        }
                    }
                };
                //将deamon线程设置为守护线程,注意:一定要在调用start()方法之前进行设置
                    //如果不将deamon设置守护线程,主线程执行完之后，由于这个线程没有结束,还会持续运行
                deamon.setDaemon(true);
                deamon.start();
            }
        };
        main.start();
    }
}
