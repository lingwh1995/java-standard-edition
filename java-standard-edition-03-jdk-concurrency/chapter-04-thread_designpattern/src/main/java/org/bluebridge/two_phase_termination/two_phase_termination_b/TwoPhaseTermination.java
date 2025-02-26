package org.bluebridge.two_phase_termination.two_phase_termination_b;

import java.util.concurrent.TimeUnit;

/**
 * 1.使用volatile的原因
 *      这个字段可能会被多个线程所使用，进行修改，为了保护该字段，则可以利用同步方法或者同步代码块来保护，或者使用volatile。
 *      使用volatile修饰的字段，强制了该成员变量在每次被线程访问时，都强迫从共享内存中重读该成员变量的值。而且，当成员变量
 *      发生变化时，强迫线程将变化值回写到共享内存。这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
 * 2.这里运用了标识+中断状态来终止线程
 *      之所以不单独用一个。原因是如果仅仅利用标识，无法是的那些处于wait、sleep或者join中的线程马上停止，响应性就会很差。加
 *      入了interrupt后，就可以立刻使得这些状态下的线程中断。如果仅仅利用interrupt，由于interrupt仅仅对于wait，sleep或
 *      join处进行抛出异常，如果工作代码执行在catch里，捕获了InterruptedException后，则此时interrupt就不起作用了。
 *
 * 两阶段终止模式
 *  适用场景：适用于需要优雅终止线程的场景，如：
 *      线程正在执行一些需要清理的资源操作（如关闭文件、释放锁等）
 *      线程需要处理一些未完成的任务或状态
 *  模式优势：通过使用两阶段终止模式，可以确保线程在终止时能够正确地释放资源，避免资源泄漏或数据不一致的问题。
 */
public class TwoPhaseTermination {

    /**
     * 工作线程
     */
    public static class WorkerThread extends Thread {
        // 终止标志位
        private volatile boolean terminated = false;

        @Override
        public void run() {
            try {
                while (!terminated) {
                    // 模拟工作
                    System.out.println("Working......");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                //e.printStackTrace();
                // 捕获中断异常，处理中断
                System.out.println("Thread was interrupted......");
            } finally {
                // 第二阶段：执行清理工作
                cleanup();
            }
        }

        /**
         * 请求终止
         */
        public void terminate() {
            terminated = true;
            // 调用 interrupt() 方法中断线程，防止线程在 sleep 或 wait 状态
            interrupt();
        }

        /**
         * 清理工作
         */
        private void cleanup() {
            System.out.println("Cleaning up resources start......");

            //模拟清理工作花费了 3s
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Cleaning up resources end......");
        }
    }
}
