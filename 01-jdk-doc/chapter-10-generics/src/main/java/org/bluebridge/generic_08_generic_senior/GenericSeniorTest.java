package org.bluebridge.generic_08_generic_senior;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

public class GenericSeniorTest {
    /**
     * 使用Class<T>传递泛型类Class对象
     * @param response
     * @param object
     * @return
     * @param <T>
     */
    public static <T> List<T> parseArray(String response, Class<T> object){
        List<T> modelList = JSON.parseArray(response, object);
        return modelList;
    }

    /**
     * 定义泛型数组
     * @param args
     * @return
     * @param <T>
     */
    public static <T> T[] generateArray(T...args){
        // 返回泛型数组
        return args ;
    }
    //使用
    public static void main(String args[]){
        Integer[] nums = generateArray(1,2,3,4,5,6);
        System.out.println("nums = " + Arrays.toString(nums));

        String[] strs = generateArray("a","b","c","d","e");
        System.out.println("strs = " + Arrays.toString(strs));
    }
}
