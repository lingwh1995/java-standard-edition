package org.bluebridge.thread.thread_designpattern.thread_pre_message.thread_pre_message_b;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/18 17:20
 */
public class Helper {

    public void handle(int count,char c){
        System.out.println("    handle(" + count + "," + c +") BEGIN");
        for (int i = 0; i < count; i++) {
            slowly();
            System.out.println(c);
        }
        System.out.println("");
        System.out.println("    handle(" + count + "," + c +") END");
    }

    private void slowly() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
