package org.bluebridge.designpattern_02_guarded_suspension.guarded_suspension_c;

import java.util.concurrent.TimeUnit;

public class GuardedObjectTest {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new People().start();
        }
        TimeUnit.MILLISECONDS.sleep(1000);
        for (Integer id : Mailboxes.getIds()) {
            new Postman(id, "内容" + id).start();
        }
    }
}
