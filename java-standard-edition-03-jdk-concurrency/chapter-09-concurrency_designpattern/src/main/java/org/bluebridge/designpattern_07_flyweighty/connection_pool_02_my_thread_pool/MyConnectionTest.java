package org.bluebridge.designpattern_07_flyweighty.connection_pool_02_my_thread_pool;

import java.sql.Connection;

public class MyConnectionTest {
    public static void main(String[] args) {
        //初始化连接池
        ConnectionPool connectionPool = new ConnectionPool(2);

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                Connection conn = connectionPool.borrow();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                connectionPool.free(conn);
            }).start();
        }
    }

}
