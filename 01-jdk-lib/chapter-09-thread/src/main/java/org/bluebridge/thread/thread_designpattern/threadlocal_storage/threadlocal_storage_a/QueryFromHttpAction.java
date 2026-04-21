package org.bluebridge.thread.thread_designpattern.threadlocal_storage.threadlocal_storage_a;

/**
 * @author ronin
 */
public class QueryFromHttpAction {

    public void execute(Context context){
        String name = context.getName();
        String idCard = getIdCard(name);
        context.setIdCard(idCard);
    }

    public String getIdCard(String name){
        try {
            Thread.sleep(1_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "123456789";
    }
}
