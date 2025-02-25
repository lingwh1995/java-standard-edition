package org.bluebridge.guarded_suspension.guarded_suspension_c;

public class People extends Thread {

    @Override
    public void run() {
        //收信
        GuardedObject guardedObject = Mailboxes.createGuardedObject();
        System.out.printf("开始收信 id: %s\n", guardedObject.getId());
        Object mail = guardedObject.get(5000);
        System.out.printf("收到信 id: %s, 内容: %s\n", guardedObject.getId() ,mail);
    }
}
