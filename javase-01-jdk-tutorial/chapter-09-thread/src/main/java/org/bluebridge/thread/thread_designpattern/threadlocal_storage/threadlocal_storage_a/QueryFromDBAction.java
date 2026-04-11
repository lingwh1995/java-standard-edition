package org.bluebridge.thread.thread_designpattern.threadlocal_storage.threadlocal_storage_a;

/**
 * @author ronin
 */
public class QueryFromDBAction {

    public void execute(Context context){
        try {
            Thread.sleep(1_000L);
            String name = "Alex from db.....";
            context.setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
