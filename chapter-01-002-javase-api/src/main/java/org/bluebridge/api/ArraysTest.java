/**  
 * @Title: ArraysApi.java  
 * @Package com.dragonsoft.api.array  
 * @author ronin
 * @date 2019年3月11日  
 * @version V1.0  
 */ 
package org.bluebridge.api;



import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 数组类的高级API
 * @author ronin
 * @date 2019年3月11日  
 *    
 */
public class ArraysTest {

	/**
	 * 数组的copyOf()方法，此方法常用来增加数组长度
	 */
	@Test
	public void copyOfTest(){
		String[] strs = {"a","b","c","d","e"};
		String[] newShortThanOldArray = Arrays.copyOf(strs,1);
		System.out.println("新数组的长度比原数组的长度短:"+Arrays.toString(newShortThanOldArray));
		String[] newShortThanLongArray = Arrays.copyOf(strs,15);
		System.out.println("新数组的长度比原来数组长度长:"+Arrays.toString(newShortThanLongArray));
	}

	/**
	 * 数组的copyOfRange()方法，此方法常用来增加数组长度
	 */
	@Test
	public void copyOfRangeTest(){
		String[] strs = {"a","b","c","d","e"};
		String[] newShortThanOldArray = Arrays.copyOfRange(strs,1,3);
		System.out.println("新数组的长度比原数组的长度短:"+Arrays.toString(newShortThanOldArray));
		String[] newShortThanLongArray = Arrays.copyOfRange(strs,1,8);
		System.out.println("新数组的长度比原来数组长度长:"+Arrays.toString(newShortThanLongArray));
	}

	/**
	 * 数组的排序方法，采用优化的快速排序算法(默认从小到大排序)
	 */
	@Test
	public void sortTest(){
		Integer[] nums = {8,2,5,9,6,3,1};
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		Character[] chars = {'b','g','c','d'};
		Arrays.sort(chars);
		System.out.println(Arrays.toString(chars));
	}


	/**
	 * 数组的二分查找方法，注意:二分查找前提是数组有序
	 */
	@Test
	public void binarySearchTest(){
		Integer[] nums = {1,2,3,5,6,9,10};
		int index = Arrays.binarySearch(nums,3);
		System.out.println(index);
	}

	/**
	 * 数组的二分查找方法重载，注意:二分查找前提是数组有序
	 */
	@Test
	public void binarySearchOverloadTest(){
		Integer[] nums = {1,2,3,5,6,9,10};
		int index = Arrays.binarySearch(nums,0,2,10);
		System.out.println(index);
	}

	/**
	 * 把数组所有的元素的值设置为某个值
	 * 		注意：这个方法会把数组中所有的元素都替换掉
	 */
	@Test
	public void fillTest(){
		String[] strs = new String[5];
		Arrays.fill(strs,"H");
		System.out.println(Arrays.toString(strs));
		
		Integer[] nums = {1,2,3,4,5};
		Arrays.fill(nums,88);
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * 数组的大小相同，对应下标位置的元素也相同，则返回true
	 */
	@Test
	public void equalsTest(){
		String[] strs1 = {"1","2","3","4","5"};
		String[] strs2 = {"1","2","3","4","5"};
		String[] strs3 = new String[]{"1","2","3","4","5"};
		System.out.println(Arrays.equals(strs1,strs2));
		System.out.println(Arrays.equals(strs1,strs3));
	}

	/**
	 * 把数组转换成为List	Array->List:Arrays.asList()  List->Array:List.toArray()
	 */
	@Test
	public void asListTest(){
		List<String> list = Arrays.asList("1", "2", "3", "4", "5");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			String element = iterator.next();
			System.out.println(element);
		}
	}


}
