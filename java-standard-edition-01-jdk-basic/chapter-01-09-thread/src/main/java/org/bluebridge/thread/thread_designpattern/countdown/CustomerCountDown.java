package org.bluebridge.thread.thread_designpattern.countdown;

/**
 * @author ronin
 */
public class CustomerCountDown {
    private final int total;
    private  int counter;

    public CustomerCountDown(int total) {
        this.total = total;
    }

    public void countDown(){
        synchronized (this){
           this.counter++;
           this.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this){
            while(counter != total){
                this.wait();
            }
        }
    }
}
