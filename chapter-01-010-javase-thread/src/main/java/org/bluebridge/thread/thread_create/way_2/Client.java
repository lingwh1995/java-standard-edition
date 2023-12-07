package org.bluebridge.thread.thread_create.way_2;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/11 17:28
 */
public class Client {
    public static void main(String[] args) {
        new Thread(new PrintThread("Bob!")).start();
        new Thread(new PrintThread("Sala!")).start();
        new Thread(new PrintThread("Mick!")).start();
        new Thread(new PrintThread("Jhon!")).start();

        //使用ThreadFactory启动线程
        ThreadFactory factory = Executors.defaultThreadFactory();
        factory.newThread(new PrintThread("ThreadFactory")).start();
    }
}
