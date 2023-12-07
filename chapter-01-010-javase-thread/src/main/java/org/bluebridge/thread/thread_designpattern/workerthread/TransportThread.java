package org.bluebridge.thread.thread_designpattern.workerthread;

import java.util.Random;

/**
 * @author ronin
 */
public class TransportThread extends Thread{
    private final Channel channel;
    private final static Random random = new Random(System.currentTimeMillis());
    
    public TransportThread(String name,Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try{
            for(int i=0;true;i++){
                Request request = new Request(getName(), i);
                this.channel.put(request);
                Thread.sleep(random.nextInt(1_000));
            }
        }catch(Exception e){

        }
    }
}
