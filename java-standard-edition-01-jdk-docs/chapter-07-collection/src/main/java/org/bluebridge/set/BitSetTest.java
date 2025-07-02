package org.bluebridge.set;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * TODO BiSet属于数据结构范围知识
 */
@Slf4j
public class BitSetTest {

    /**
     * BitSet HelloWorld案例
     */
    @Test
    public void testBitSetHelloWorld() {
        //创建一个具有10000000位的bitset　初始所有位的值为false
        BitSet bitSet = new BitSet(10000000);
        //将指定位的值设为true
        bitSet.set(9999);
        //或者bitSet.set(9999,true);
        //输出指定位的值
        System.out.println("9999:"+bitSet.get(9999));
        System.out.println("9998:"+bitSet.get(9998));
    }

    /**
     * 使用BitSet统计随机数的个数
     */
    public void testBitSetCountRandom() {
        Random random = new Random();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<100;i++){
            int randomResult=random.nextInt(100);
            list.add(randomResult);
        }
        log.debug("0~100之间产生的随机数有:");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        System.out.println("0~100之间的随机数产生了"+list.size()+"个");
        BitSet bitSet=new BitSet(100);
        for(int i=0;i<100;i++)
        {
            bitSet.set(list.get(i));
        }
        //public int cardinality()方法返回此BitSet中比特设置为true的数目
        //就是BitSet中存放的有效位的个数，如果有重复运算会进行自动去重
        System.out.println("0~100存在BitSet的随机数有"+bitSet.cardinality()+"个");
        System.out.print("0~100不在上述随机数中有:");
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if(!bitSet.get(i))
            {
                System.out.print(i+" ");
                count++;
            }
        }
        System.out.println();
        //0~100不在产生的随机数中的个数就是100减去存在BitSet的随机数个数
        System.out.print("0~100不在产生的随机数中的个数为:"+count+"个");
    }

}
