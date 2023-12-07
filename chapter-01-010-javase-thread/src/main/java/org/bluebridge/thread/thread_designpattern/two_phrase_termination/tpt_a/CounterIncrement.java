package org.bluebridge.thread.thread_designpattern.two_phrase_termination.tpt_a;

import java.util.Random;

/**
 * @author ronin
 */
public class CounterIncrement extends Thread{

    private volatile boolean terminated = false;
    private int counter = 0;
    private Random random = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        try{
            while(!terminated){
                System.out.println(Thread.currentThread().getName() + " "+ counter++);
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            this.clean();
        }
    }

    private void clean() {
        System.out.println("do some clean for the second phase,current counter:" + counter);
    }

    public void close() {
        this.terminated = true;
        this.interrupt();
    }
}
