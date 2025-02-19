package org.bluebridge.lock_08_synchronized_object_header;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * 64位虚拟机中Object Header中markword结构
 * |-----------------------------------------------------------------------------------------------------------------|
 * |                                             Object Header(128bits)                                              |
 * |-----------------------------------------------------------------------------------------------------------------|
 * |                                   Mark Word(64bits)               |  Klass Word(64bits)    |      State         |
 * |-----------------------------------------------------------------------------------------------------------------|
 * | unused:25|identity_hashcode:31|unused:1|age:4|biase_lock:1|lock:2 | OOP to metadata object |      Nomal         |
 * |-----------------------------------------------------------------------------------------------------------------|
 * | thread:54|      epoch:2       |unused:1|age:4|biase_lock:1|lock:2 | OOP to metadata object |      Biased        |
 * |-----------------------------------------------------------------------------------------------------------------|
 * |                     ptr_to_lock_record:62                 |lock:2 | OOP to metadata object | Lightweight Locked |
 * |-----------------------------------------------------------------------------------------------------------------|
 * |                    ptr_to_heavyweight_monitor:62          |lock:2 | OOP to metadata object | Heavyweight Locked |
 * |-----------------------------------------------------------------------------------------------------------------|
 * |                                                           |lock:2 | OOP to metadata object |    Marked for GC   |
 * |-----------------------------------------------------------------------------------------------------------------|
 */

/**
 * 注意：运行前要关闭指针压缩，添加如下vm参数即可：-XX:-UseCompressedOops
 */
public class ObjectHeaderTest {

    public static void main(String[] args) throws InterruptedException {
        //对象
        Object obj = new Object();
        //数组
        String[] array = new String[]{};
        // 打印jvm的具体参数
        System.out.println(VM.current().details());
        System.out.println("---------------------------------------------------------------");

        // 打印普通对象头信息
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.out.println("---------------------------------------------------------------");

        // 打印数组对象头信息
        System.out.println(ClassLayout.parseInstance(array).toPrintable());
        System.out.println("---------------------------------------------------------------");
    }
}
