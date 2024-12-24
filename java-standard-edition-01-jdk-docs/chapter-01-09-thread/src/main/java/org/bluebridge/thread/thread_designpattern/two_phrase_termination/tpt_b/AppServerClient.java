package org.bluebridge.thread.thread_designpattern.two_phrase_termination.tpt_b;

import java.io.IOException;

/**
 * @author ronin
 */
public class AppServerClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        AppServer server = new AppServer(8888);
        server.start();
        //使用 telnet localhost 8888 连接到此程序
        Thread.sleep(45_000L);
        server.shutdown();
    }
}
