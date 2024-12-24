package org.bluebridge.thread.thread_demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author ronin
 */
public class SimpleThreadPool extends Thread{
    private int size;
    private final int queueSize;
    private final static LinkedList<Runnable>  TASK_QUEUE = new LinkedList<>();
    private static volatile int seq = 0;
    private final static String TREAD_PREIX = "SIMPLE_THREAD_POOL_";
    private final static ThreadGroup GROUP = new ThreadGroup("Pool_Group");
    private final static List<WorkTask> THREAD_QUEUE = new ArrayList<>();
    private final static int DEFAULT_TASK_QUEUE_SIZE = 2000;
    private final DiscardPolicy discardPolicy;
    private volatile boolean destroy = false;
    private int min;
    private int max;
    private int active;
    private final static DiscardPolicy DEFAULT_DISCARD_POLICY =
            ()->{throw new DiscardExcption("discard this task......");};
    public SimpleThreadPool() {
        this(4,8,12,DEFAULT_TASK_QUEUE_SIZE,DEFAULT_DISCARD_POLICY);
    }

    public SimpleThreadPool(int min,int active,int max,int queueSize, DiscardPolicy discardPolicy) {
        this.min = min;
        this.active = active;
        this.max = max;
        this.queueSize = queueSize;
        this.discardPolicy = discardPolicy;
        init();
    }

    public int getSize() {
        return size;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public int getActive() {
        return active;
    }

    public boolean isDestroy(){
        return this.destroy;
    }

    private void init(){
        for (int i = 0; i < this.min; i++) {
            createWorkTask();
        }
        this.size = min;
        this.start();
    }

    @Override
    public void run() {
        while(!destroy){
            System.out.printf("Pool#Min:%d,Active:%d,Max:%d,Current:%d,QueueSize:%d\n",
                    this.min,this.active,this.max,this.size,TASK_QUEUE.size());
            try {
                Thread.sleep(5_000);
                if(TASK_QUEUE.size()>active && size<active){
                    for(int i=size;i<active;i++){
                        createWorkTask();
                    }
                    size = active;
                    System.out.println("The pool incremented.....");
                }else if(TASK_QUEUE.size()>max && size<max){
                    for(int i=size;i<max;i++){
                        createWorkTask();
                    }
                    size = max;
                    System.out.println("The pool incremented max.....");
                }
                synchronized (TASK_QUEUE){
                    if(TASK_QUEUE.isEmpty() && size>active){
                        int releaseSize = size - active;
                        for(Iterator<WorkTask> it = THREAD_QUEUE.iterator();it.hasNext();){
                            if(releaseSize<0){
                                break;
                            }
                            WorkTask workTask = it.next();
                            workTask.close();
                            workTask.interrupt();
                            it.remove();
                            releaseSize--;
                        }
                        size = active;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void submit(Runnable runnable){
        if(destroy){
            throw new IllegalStateException("The thread pool already destory and not allow submit......");
        }
        synchronized (TASK_QUEUE){
            if(TASK_QUEUE.size() > queueSize){
                discardPolicy.discard();
            }
            TASK_QUEUE.addLast(runnable);
            TASK_QUEUE.notifyAll();
        }
    }

    public void createWorkTask(){
        WorkTask workTask = new WorkTask(GROUP,TREAD_PREIX+(seq++));
        workTask.start();
        THREAD_QUEUE.add(workTask);
    }

    public void shutdown() throws InterruptedException{
        while (!TASK_QUEUE.isEmpty()){
            Thread.sleep(50);
        }
        int initValue = THREAD_QUEUE.size();
        while (initValue>0){
            for(WorkTask task: THREAD_QUEUE){
                if(task.getTaskState() == TaskState.BLOCKED){
                    task.interrupt();
                    task.close();
                    initValue--;
                }else {
                    Thread.sleep(10);
                }
            }
        }
        System.out.println("activeCount:"+GROUP.activeCount());
        this.destroy = true;
        System.out.println("The thread pool disposed......");
    }

    /**
     * 线程状态枚举
     */
    private enum TaskState{
        FREE,RUNNING,BLOCKED,DEAD
    }

    /**
     * 工作线程
     */
    private static class WorkTask extends Thread{
        private TaskState taskState = TaskState.FREE;

        public WorkTask(ThreadGroup group, String name) {
            super(group,name);
        }

        public TaskState getTaskState() {
            return taskState;
        }

        public void close(){
            this.taskState = TaskState.DEAD;
        }

        @Override
        public void run() {
            OUTER:
            while (this.taskState != TaskState.DEAD){
                Runnable runnable = null;
                synchronized (TASK_QUEUE){
                    while (TASK_QUEUE.isEmpty()){
                        try {
                            taskState = TaskState.BLOCKED;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            //e.printStackTrace();
                            System.out.println("Closed......");
                            break OUTER;
                        }
                    }
                    runnable = TASK_QUEUE.removeFirst();
                }
                if(runnable != null){
                    this.taskState = TaskState.RUNNING;
                    runnable.run();
                    this.taskState = TaskState.FREE;
                }
            }
        }
    }

    private static class DiscardExcption extends RuntimeException{
        public DiscardExcption(String msg) {
            super(msg);
        }
    }
    public interface DiscardPolicy{
        void discard() throws DiscardExcption;
    }
    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool threadPool = new SimpleThreadPool();
        //SimpleThreadPool threadPool = new SimpleThreadPool(6,10,SimpleThreadPool.DEFAULT_DISCARD_POLICY);
        IntStream.rangeClosed(0,200).forEach(i->{
            threadPool.submit(()->{
                //System.out.println("The runner:"+i+" be serviced by "+Thread.currentThread()+" started.....");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println("The runner:"+i+" be serviced by "+Thread.currentThread()+" finished......");
            });
        });
        Thread.sleep(30_000);
        threadPool.shutdown();
//        threadPool.submit(()->
//            System.out.println("Hello World!")
//        );
    }
}
