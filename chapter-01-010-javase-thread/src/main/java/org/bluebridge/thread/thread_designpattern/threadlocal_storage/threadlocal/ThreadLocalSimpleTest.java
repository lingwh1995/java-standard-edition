package org.bluebridge.thread.thread_designpattern.threadlocal_storage.threadlocal;

/**
 * @author ronin
 */
public class ThreadLocalSimpleTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String> (){
        @Override
        protected String initialValue() {
            return "Alex";
        }
    };

    public static void main(String[] args) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result = threadLocal.get();
        System.out.println(result);
    }
}
