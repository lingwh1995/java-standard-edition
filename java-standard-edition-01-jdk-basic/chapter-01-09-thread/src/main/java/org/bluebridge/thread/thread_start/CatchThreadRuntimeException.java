package org.bluebridge.thread.thread_start;

/**
 * @author ronin
 */
public class CatchThreadRuntimeException {
    public static void main(String[] args) {
        /**
         * 注意:下面这段代码的异常只能try{}catch{}，不能抛出,要捕获这个异常,使用:
         * setUncaughtExceptionHandler()这个方法获取
         */
       Thread t =  new Thread(()->{
            try {
                Thread.sleep(1_000);
                int i = 1 / 0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
       t.setUncaughtExceptionHandler((thread,e)->{
           System.out.println(thread);
           System.out.println(e);
       });
       t.start();

    }
}
