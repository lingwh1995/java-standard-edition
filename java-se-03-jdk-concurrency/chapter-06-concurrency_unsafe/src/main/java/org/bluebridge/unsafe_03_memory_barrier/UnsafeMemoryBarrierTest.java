package org.bluebridge.unsafe_03_memory_barrier;

import org.bluebridge.util.UnsafeAccessor;
import sun.misc.Unsafe;

/**
 * Unsafe应用二    内存屏障
 *      public native void loadFence();  //禁止读操作重排序
 *      public native void storeFence(); //禁止写操作重排序
 *      public native void fullFence();  //禁止读、写操作重排序
 */
public class UnsafeMemoryBarrierTest {
    public static void main(String[] args) {
        ChangeThread changeThread = new ChangeThread();
        new Thread(changeThread).start();
        while (true) {
            boolean flag = changeThread.isFlag();
            Unsafe unsafe = UnsafeAccessor.getUnsafe();
            unsafe.loadFence(); //加入读内存屏障
            if (flag){
                System.out.println("detected flag changed......");
                break;
            }
        }
        System.out.println("main thread end......");
    }
}
