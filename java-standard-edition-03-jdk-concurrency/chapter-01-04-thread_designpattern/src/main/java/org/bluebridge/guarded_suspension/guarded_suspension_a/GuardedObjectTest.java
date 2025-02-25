package org.bluebridge.guarded_suspension.guarded_suspension_a;

import java.io.IOException;
import java.util.List;

public class GuardedObjectTest {

    //线程1 等待 线程2 的下载结果
    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();
        new Thread(()->{
            System.out.println("等待结果......");
            List <String>  result = (List<String>) guardedObject.get();
            System.out.println("结果大小：" + result.size());
        },"t1").start();

        new Thread(()->{
            System.out.println("执行下载......");
            try {
                List <String> result = Downloader.download();
                guardedObject.complete(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }

}
