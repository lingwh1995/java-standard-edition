package org.bluebridge.flyweighty.connection_pool_01;

import java.sql.Connection;

public class MyConnectionTest {
    public static void main(String[] args) {
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
