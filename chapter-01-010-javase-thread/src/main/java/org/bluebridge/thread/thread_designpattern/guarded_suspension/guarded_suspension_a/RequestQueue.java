package org.bluebridge.thread.thread_designpattern.guarded_suspension.guarded_suspension_a;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/16 9:06
 */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<> ();

    public synchronized Request getRequest(){
        try {
            while (queue.peek() == null){
                    wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request){
        queue.offer(request);
        notifyAll();
    }
}
