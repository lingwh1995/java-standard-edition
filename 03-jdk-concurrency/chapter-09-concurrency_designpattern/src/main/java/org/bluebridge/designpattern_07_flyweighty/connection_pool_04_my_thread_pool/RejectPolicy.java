package org.bluebridge.designpattern_07_flyweighty.connection_pool_04_my_thread_pool;

@FunctionalInterface //拒绝策略
interface RejectPolicy<T>{
    void reject(BlockingQueue<T> queue, T task);
}