package org.bluebridge.thread.thread_designpattern.readwritelock.readwritelock_e;

import java.util.Random;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/18 13:27
 */
public class WriteThread extends Thread {
    private static final Random random = new Random();
    private final Data data;
    private final String filter;
    private int index = 0;

    public WriteThread(Data data, String filter) {
        this.data = data;
        this.filter = filter;
    }

    @Override
    public void run() {
        try {
            while(true){
                char c = nextchar();
                data.write(c);
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextchar() {
        char c = filter.charAt(index);
        index++;
        if(index >=filter.length()){
            index = 0;
        }
        return c;
    }
}
