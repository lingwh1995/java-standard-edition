package org.bluebridge.java8.async_concurrency;


import org.junit.Test;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {

    @Test
    public void test() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Running in async mode");
        });
    }
}
