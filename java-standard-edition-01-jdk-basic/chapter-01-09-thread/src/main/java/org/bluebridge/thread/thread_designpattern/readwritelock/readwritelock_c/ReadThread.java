package org.bluebridge.thread.thread_designpattern.readwritelock.readwritelock_c;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/18 13:32
 */
public class ReadThread extends Thread{
    private final Data data;

    public ReadThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while(true){
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName()+"reads:"+String.valueOf(readBuf));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
