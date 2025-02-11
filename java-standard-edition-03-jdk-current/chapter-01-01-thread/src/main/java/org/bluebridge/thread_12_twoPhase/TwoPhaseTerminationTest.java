package org.bluebridge.thread_12_twoPhase;

import java.util.concurrent.TimeUnit;

/**
 * 测试两阶段终止线程
 */
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
