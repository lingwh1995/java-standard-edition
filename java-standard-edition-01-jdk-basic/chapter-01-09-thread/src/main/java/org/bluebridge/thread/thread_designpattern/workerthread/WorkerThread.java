package org.bluebridge.thread.thread_designpattern.workerthread;

import java.util.Random;

/**
 * @author ronin
 */
public class WorkerThread extends Thread{

    private final Channel channel;
    private final static Random random = new Random(System.currentTimeMillis());

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while(true){
            channel.take().execute();
            try {
                Thread.sleep(random.nextInt(1_000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
