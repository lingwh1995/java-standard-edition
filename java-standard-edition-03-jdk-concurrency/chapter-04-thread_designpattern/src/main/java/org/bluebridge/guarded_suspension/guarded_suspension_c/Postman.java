package org.bluebridge.guarded_suspension.guarded_suspension_c;

public class Postman extends Thread {

    private int id;
    private String mail;

    public Postman(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    @Override
    public void run() {
        GuardedObject guardedObject = Mailboxes.getGuardedObject(id);
        System.out.printf("送信 id:%s, 内容:%s\n", id, mail);
        guardedObject.complete(mail);
    }
}
