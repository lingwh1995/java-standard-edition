package org.bluebridge.thread.thread_designpattern.future.future_c;


/**
 * @author ronin
 */
public class FutureClient {
    public static void main(String[] args) throws InterruptedException {
        FutureService futureService = new FutureService();
        Future<String> future = futureService.submit(() -> {
            try {
                Thread.sleep(1_0000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "FINISHED!";
        },System.out::println);
        System.out.println("---------------------------");
        System.out.println("do other things......");
        Thread.sleep(1_000L);
        System.out.println("---------------------------");
        //System.out.println(future.get());
    }
}
