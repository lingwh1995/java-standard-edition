package org.bluebridge.thread.thread_designpattern.producer_consumer.producer_consumer_b;

import java.util.Random;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/17 11:17
 */
public class EaterThread extends Thread {
    private final Random random;
    private final Table table;

    public EaterThread(String name, Table table,long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        try{
            while(true){
                String cake = table.take();
                Thread.sleep(random.nextInt(1000));
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
