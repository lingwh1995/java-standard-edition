package org.bluebridge.thread.thread_designpattern.immutable;

import java.util.stream.IntStream;

/**
 * @author ronin
 */
public class ImmutableClient {
    public static void main(String[] args) {
        Person person = new Person("Alex","ShanXi");

        IntStream.range(0,5).forEach(i -> {
            new UsePersonThread(person).start();
        });
    }
}
