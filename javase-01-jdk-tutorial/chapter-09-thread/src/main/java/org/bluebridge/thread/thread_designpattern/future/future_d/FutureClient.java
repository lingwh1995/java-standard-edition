package org.bluebridge.thread.thread_designpattern.future.future_d;


/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/10 16:56
 */
public class FutureClient {
    public static void main(String[] args) {
        FutureService futureService = new FutureService();
        Data data = futureService.request("hello,world");
        System.out.println("请求发送成功...");
        System.out.println("干其他的事情...");
        String result = data.getRequest();
        System.out.println(result);
    }
}
