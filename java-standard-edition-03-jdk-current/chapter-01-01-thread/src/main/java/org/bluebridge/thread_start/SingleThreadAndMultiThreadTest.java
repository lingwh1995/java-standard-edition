/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package org.bluebridge.thread_start;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.FutureTask;

/**
 * 单线程和多线程运行效率对比
 */
public class SingleThreadAndMultiThreadTest {

    static int[] ARRAY = new int[1000_000_000];
    static {
        Arrays.fill(ARRAY, 10);
    }

    /**
     * 多线程计算
     * @throws Exception
     */
    @Test
    public void testMultiThread() throws Exception {
        long start = System.currentTimeMillis();
        int[] array = ARRAY;
        FutureTask<Integer> t1 = new FutureTask<>(()->{
            int sum = 0;
            for(int i = 0; i < 250_000_000;i++) {
                sum += array[0+i];
            }
            return sum;
        });
        FutureTask<Integer> t2 = new FutureTask<>(()->{
            int sum = 0;
            for(int i = 0; i < 250_000_000;i++) {
                sum += array[250_000_000+i];
            }
            return sum;
        });
        FutureTask<Integer> t3 = new FutureTask<>(()->{
            int sum = 0;
            for(int i = 0; i < 250_000_000;i++) {
                sum += array[500_000_000+i];
            }
            return sum;
        });
        FutureTask<Integer> t4 = new FutureTask<>(()->{
            int sum = 0;
            for(int i = 0; i < 250_000_000;i++) {
                sum += array[750_000_000+i];
            }
            return sum;
        });
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
        new Thread(t4).start();

        int total = t1.get() + t2.get() + t3.get() + t4.get();
        System.out.println("total = " + total);
        long end = System.currentTimeMillis();
        System.out.println("Total time (ms): " + (end - start));
    }


    /**
     * 单线程计算
     * @throws Exception
     */
    @Test
    public void testSingleThread() throws Exception {
        long start = System.currentTimeMillis();
        int[] array = ARRAY;
        FutureTask<Integer> t1 = new FutureTask<>(()->{
            int sum = 0;
            for(int i = 0; i < 1000_000_000;i++) {
                sum += array[0+i];
            }
            return sum;
        });
        new Thread(t1).start();

        int total = t1.get();
        System.out.println("total = " + total);
        long end = System.currentTimeMillis();
        System.out.println("Total time (ms): " + (end - start));
    }
}
