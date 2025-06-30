package org.bluebridge.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试Set集合
 */
public class SetTest {

    /**
     * 添加成功返回true,添加失败返回false
     */
    @Test
    public void testSetAdd() {
        Set<Integer> nums = new HashSet<>();
        System.out.println(nums.add(0));    // true
        System.out.println(nums.add(1));    // true
        System.out.println(nums.add(2));    // true
        System.out.println(nums);
        System.out.println(nums.add(0));    // false
    }

}
