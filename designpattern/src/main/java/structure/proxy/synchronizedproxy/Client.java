package structure.proxy.synchronizedproxy;

import org.junit.Test;

public class Client {

    /**
     * 测试异步执行
     */
    @Test
    public void fun1(){
        Task asynchronousTask = new AsynchronousTask();
        asynchronousTask.task();
    }

    /**
     * 测试同步执行
     */
    @Test
    public void fun2(){
        //测试异步代码块
        Task asynchronousTask = new AsynchronousTask();
        //测试同步代理
        SynchronizedProxy synchronizedProxy = new SynchronizedProxy(asynchronousTask);
        synchronizedProxy.task();
    }
}
