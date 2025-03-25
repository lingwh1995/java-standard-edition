package org.bluebridge.thread_pool_02_thread_pool;

@FunctionalInterface //拒绝策略
interface RejectPolicy<T>{
    void reject(BlockingQueue<T> queue, T task);
}