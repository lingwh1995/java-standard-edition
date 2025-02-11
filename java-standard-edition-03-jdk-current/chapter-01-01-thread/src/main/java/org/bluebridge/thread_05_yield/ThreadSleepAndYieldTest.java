package org.bluebridge.thread_05_yield;

/**
 * sleep()和yield()对比
 *
 *   sleep()
 *     1. 调用 sleep 会让当前线程从 Running 进入 Timed Waiting 状态（阻塞）
 *     2. 其它线程可以使用 interrupt 方法打断正在睡眠的线程，这时 sleep 方法会抛出 InterruptedException
 *     3. 睡眠结束后的线程未必会立刻得到执行
 *     4. 建议用 TimeUnit 的 sleep 代替 Thread 的 sleep 来获得更好的可读性
 *
 *   yield()
 *     1. 调用 yield 会让当前线程从 Running 进入 Runnable 就绪状态，然后调度执行其它线程
 *     2. 具体的实现依赖于操作系统的任务调度器
 */
public class ThreadSleepAndYieldTest {
}
