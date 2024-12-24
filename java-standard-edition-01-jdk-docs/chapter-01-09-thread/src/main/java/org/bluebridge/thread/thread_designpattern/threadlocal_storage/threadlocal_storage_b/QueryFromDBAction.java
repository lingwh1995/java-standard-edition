package org.bluebridge.thread.thread_designpattern.threadlocal_storage.threadlocal_storage_b;

/**
 * @author ronin
 */
public class QueryFromDBAction {

    public void execute(){
        try {
            final Context context = ActionContext.getInstance().getContext();
            Thread.sleep(1_000L);
            String name = "Alex from db.....";
            context.setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
