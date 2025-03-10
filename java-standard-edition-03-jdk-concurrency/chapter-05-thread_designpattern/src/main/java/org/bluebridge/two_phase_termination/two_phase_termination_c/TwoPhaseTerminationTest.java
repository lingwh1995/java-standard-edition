package org.bluebridge.two_phase_termination.two_phase_termination_c;

import java.util.concurrent.TimeUnit;

/**
 * 测试两阶段终止线程
 */
public class TwoPhaseTerminationTest {
    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination tpt = new TwoPhaseTermination();
        tpt.start();

        TimeUnit.MILLISECONDS.sleep(3500);
        tpt.stop();
    }
}
