package org.bluebridge.thread.thread_start;

/**
 * 退出时增加钩子程序
 * @author ronin
 */
public class ExitCapture {
    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(()->{
            System.out.println("程序执行完成......");
        }));
        System.out.println("程序执行中......");
    }
}
