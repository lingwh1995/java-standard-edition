package org.bluebridge.api;

import org.junit.Test;

import java.util.Arrays;

public class SystemTest {

    /**
     * System的arraycopy()方法，此方法常用来执行比较复杂的数组拷贝
     */
    @Test
    public void arraycopyTest(){
        String[] strs = {"a","b","c","d","e"};
        String[] newShortThanOldArray = {"null","null","null","null","null"};
        System.arraycopy(strs, 0, newShortThanOldArray, 0, 2);
        System.out.println("newShortThanOldArray:"+ Arrays.toString(newShortThanOldArray));

        String[] newShortThanLongArray = {"null","null","null","null","null","null","null","null","null","null"};
        System.arraycopy(strs, 1, newShortThanLongArray, 2, 3);
        System.out.println("newShortThanLongArray:"+Arrays.toString(newShortThanLongArray));
    }
}
