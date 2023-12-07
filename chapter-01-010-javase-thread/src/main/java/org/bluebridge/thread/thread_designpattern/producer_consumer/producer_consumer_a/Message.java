package org.bluebridge.thread.thread_designpattern.producer_consumer.producer_consumer_a;

/**
 * @author ronin
 */
public class Message {
    private String data;

    public Message(String data) {
        this.data = data;
    }

    public String getData(){
        return data;
    }
}
