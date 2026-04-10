package org.bluebridge.thread.thread_designpattern.thread_pre_message.thread_pre_message_a;

import java.util.stream.IntStream;

/**
 * @author ronin
 */
public class PreThreadClient {
    public static void main(String[] args) {
        MessageHandler handler = new MessageHandler();
        IntStream.rangeClosed(0,10).forEach(i->{
            handler.request(new Message(String.valueOf(i)));
        });
    }
}
