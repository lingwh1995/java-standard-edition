package org.bluebridge.lock_10_synchronized_monitor;

/**
 * 同步方法Monitor测试
 *  1.终端中输入如下命令
 *      javac .\MonitorSynchronizedMethodTest.java -> javap -v .\MonitorSynchronizedMethodTest.class
 *  2.得到如下字节码（只展示核心部分）
 *    public synchronized void testMonitor();
 *     descriptor: ()V
 *     flags: (0x0021) ACC_PUBLIC, ACC_SYNCHRONIZED
 *     Code:
 *       stack=2, locals=1, args_size=1
 *          0: getstatic     #7                  // Field java/lang/System.out:Ljava/io/PrintStream;
 *          3: ldc           #13                 // String hello monitor......
 *          5: invokevirtual #15                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 *          8: return
 *       LineNumberTable:
 *         line 34: 0
 *         line 35: 8
 *  3.可以观察到同步方法通过在 flags中添加 ACC_SYNCHRONIZED 标识符来实现同步
 */
public class MonitorSynchronizedMethodTest {
    public synchronized void testMonitor() {
        System.out.println("hello monitor......");
    }
}
