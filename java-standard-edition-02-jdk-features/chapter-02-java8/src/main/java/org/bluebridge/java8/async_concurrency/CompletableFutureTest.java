package org.bluebridge.java8.async_concurrency;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

@Slf4j(topic = "·")
public class CompletableFutureTest {

    @Test
    public void test() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            log.info("running in async mode......");
        });
    }

}
