package org.bluebridge.thread.thread_designpattern.single_thread;

/**
 * @author ronin
 */
public class UserThread extends Thread {
    private final String name;
    private final String address;
    private final Gate gate;

    public UserThread(Gate gate,String name, String address) {
        this.gate = gate;
        this.name = name;
        this.address = address;
    }

    @Override
    public void run() {
        System.out.println(this.name +" BEGIN......");
        while(true){
            this.gate.pass(this.name,this.address);
        }
    }
}

