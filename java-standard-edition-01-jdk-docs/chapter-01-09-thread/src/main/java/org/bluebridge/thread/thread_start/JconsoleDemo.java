package org.bluebridge.thread.thread_start;

/**
 * 使用jconsole监控线程
 * -Dcom.sun.management.jmxremote
 * @author ronin
 */
public class JconsoleDemo {
    public static void main(String[] args) {
      new Thread("READ-THREAD"){
          @Override
          public void run() {
              read();
          }
      }.start();
      new Thread("WRITE-THREAD"){
          @Override
          public void run() {
              write();
          }
      }.start();
    }

    /**
     * 读文件
     */
    public static void read(){
        System.out.println("READ FROM FILE......");
        try {
            Thread.sleep(10000*80L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写文件
     */
    public static void write(){
        System.out.println("WRITE TO DB......");
        try {
            Thread.sleep(10000*80L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
