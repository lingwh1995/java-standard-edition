package org.bluebridge.thread_tpt;

import java.util.concurrent.TimeUnit;

public class TwoPhaseTerminationTest {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination tpt = new TwoPhaseTermination();
        tpt.start();
//        tpt.start();
//        tpt.start();

        TimeUnit.MILLISECONDS.sleep(3500);
        System.out.println("停止监控...");
        tpt.stop();
    }
}
