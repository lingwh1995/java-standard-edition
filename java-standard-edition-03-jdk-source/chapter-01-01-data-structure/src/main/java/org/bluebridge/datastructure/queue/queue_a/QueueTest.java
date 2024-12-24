package org.bluebridge.datastructure.queue.queue_a;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/8/5 14:21
 */
public class QueueTest {

    @Test
    public void testQueue() {
        Queue<String> queue = new LinkedList<>();
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        System.out.println("queue:"+queue);
        System.out.println("size:"+queue.size());
        String str = null;
        while((str = queue.poll()) != null){
            System.out.print(str);
        }
        System.out.println("size:"+queue.size());
    }
}
