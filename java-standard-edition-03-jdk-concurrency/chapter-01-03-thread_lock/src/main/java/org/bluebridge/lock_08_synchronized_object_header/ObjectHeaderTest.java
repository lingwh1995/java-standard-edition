package org.bluebridge.lock_08_synchronized_object_header;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class ObjectHeaderTest {
    public static void main(String[] args) {
        //对象
        Student student = new Student();
        //数组
        String[] strings = new String[]{};
        // 打印jvm的具体参数
        System.out.println(VM.current().details());

        /*
         * //64位虚拟机
         * # VM mode: 64 bits
         * # Compressed references (oops): 3-bit shift
         * # Compressed class pointers: 0-bit shift and 0x1E591000000 base
         * //按照8个字节对齐，即忽略第一个8字节
         * # Object alignment: 8 bytes
         * #                       ref, bool, byte, char, shrt,  int,  flt,  lng,  dbl
         * # Field sizes:            4,    1,    1,    2,    2,    4,    4,    8,    8
         * # Array element sizes:    4,    1,    1,    2,    2,    4,    4,    8,    8
         * # Array base offsets:    16,   16,   16,   16,   16,   16,   16,   16,   16
         */


        // 打印普通对象头信息
        System.out.println(ClassLayout.parseInstance(student).toPrintable());
        /*
         * org.bluebridge.lock_08_synchronized_jol.Student object internals:
         * OFF  SZ   TYPE DESCRIPTION               VALUE
         *   0   8        (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
         *   8   4        (object header: class)    0x01002a00
         *  12   4        (object alignment gap)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         */


        // 打印数组对象头信息
        System.out.println(ClassLayout.parseInstance(strings).toPrintable());

        /*
         * [Ljava.lang.String; object internals:
         * OFF  SZ               TYPE DESCRIPTION               VALUE
         *   0   8                    (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
         *   8   4                    (object header: class)    0x0000e800
         *  12   4                    (array length)            0
         *  16   0   java.lang.String String;.<elements>        N/A
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
         */
    }
}
