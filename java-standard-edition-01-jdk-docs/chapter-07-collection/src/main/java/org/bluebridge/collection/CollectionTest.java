package org.bluebridge.collection;

import java.util.*;

import org.junit.Test;

/**
 * @author ronin
 */
public class CollectionTest {

	public static void main(String[] args) {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("2");
		list2.add("3");
		list2.add("4");
		System.out.println("list1:"+list1.toString());//list1:[1, 2, 3]
		System.out.println("list2:"+list2.toString());//list2:[2, 3, 4]

//		boolean addAll = list1.addAll(list2);
//		System.out.println("list1.addAll(list2) :"+list1.toString());//list1.addAll(list2) :[1, 2, 3, 2, 3, 4]

//		boolean removeAll = list1.removeAll(list2);
//		System.out.println("list1.removeAll(list2):"+list1.toString());//list1.removeAll(list2):[1]

		/**
		 * 取交集
		 */
//		boolean retainAll = list1.retainAll(list2);
//		System.out.println("list1.retainAll(list2):"+list1.toString());//list1.retainAll(list2):[2, 3]

		System.out.println(list1.containsAll(list2));
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("2");
		System.out.println(list1.containsAll(list3));

		System.out.println("---------------------------------------------------------------------------");

		Set<String> set1 = new HashSet<String>();
		set1.add("1");
		set1.add("2");
		set1.add("3");
		Set<String> set2 = new HashSet<String>();
		set2.add("2");
		set2.add("3");
		set2.add("4");

		System.out.println("set1:"+set1.toString());
		System.out.println("set2:"+set2.toString());
		set1.addAll(set2);

		/**
		 * 会自动去重
		 */
		System.out.println("set1.addAll(set2):"+set1.toString());
	}

	/**
	 * 测试addAll()	把B的值全部添加到A里面
	 */
	@Test
	public void testCollectionAddAll() {
        Collection<String> c1 = new ArrayList<>();
        c1.add("a");
        c1.add("b");
        c1.add("c");
        System.out.println(c1);
        
        Collection<String> c2 = new ArrayList<>();
        c2.add("d");
        c2.add("e");
        c2.add("f");
        System.out.println(c2);
        
        //把c2中的元素全部添加到c1中
        c1.addAll(c2);
        
        System.out.println(c1);
	}
	
	/**
	 * 测试removeAll()	从A里面移除B中的全部元素，前提是B里面的元素在A里面也有，只要移除了最少一个元素就返回true
	 * 		1.相当于从c1中移除c1、c2交集部分
	 * 		2.只要移除了就返回true
	 */
	@Test
	public void testCollectionRemoveAll() {
		Collection<String> c1 = new ArrayList<>();
		c1.add("a");
		c1.add("b");
		c1.add("c");
		c1.add("d");
		c1.add("e");
		System.out.println(c1);
		
		Collection<String> c2 = new ArrayList<>();
		c2.add("b");
		c2.add("c");
		c2.add("x");
		System.out.println(c2);
		
		Collection<String> c3 = new ArrayList<>();
		c3.add("d");
		c3.add("e");
		c3.add("y");
		System.out.println(c3);
		
		//从c1中移除所有存在于c2且存在于c1中的元素
		System.out.println(c1.removeAll(c2));
		System.out.println(c1);
		
		//从c1中移除所有存在于c3且存在于c1中的元素
		System.out.println(c1.removeAll(c3));
		System.out.println(c1);
	}
	
	/**
	 * 测试contains()		A里面是否包含某个元素，包含返回true
	 * 测试containsAll()		A里面是否包含集合B中的全部元素，全部包含返回true
	 */
	@Test
	public void testCollectionContainsAndContainsAll() {
        Collection<String> c1 = new ArrayList<>();
        c1.add("a");
        c1.add("b");
        c1.add("c");
        Collection<String> c2 = new ArrayList<>();
        c2.add("b");
        c2.add("c");
        Collection<String> c3 = new ArrayList<>();
        c3.add("b");
        c3.add("c");
        c3.add("d");

        System.out.println(c1.contains(c2));
        System.out.println(c1.contains(c3));
        System.out.println(c1.containsAll(c2));
        System.out.println(c1.containsAll(c3));

	}
	
	/**
	 * 测试retainAll()	A与B做交集，交集的值保存在A中，方法执行完成后,如果A的值发生了改变,则返回true，如果A的值没发生改变,则返回false
	 */
	@Test
	public void testCollectionRetainAll() {
		Collection<String> c1 = new ArrayList<>();
		c1.add("a");
		c1.add("b");
		c1.add("c");
		Collection<String> c2 = new ArrayList<>();
		c2.add("b");
		c2.add("c");
		
		System.out.println(c1.retainAll(c2));
		System.out.println(c1);
	}
	
	/**
	 * 测试clear()	清除集合中的所有元素
	 */
	@Test
	public void testCollectionClear() {
		Collection<String> c = new ArrayList<>();
		c.add("a");
		c.add("b");
		c.add("c");
		c.clear();
		System.out.println(c);
	}

	/**
	 * 判断集合是否为空
	 */
	@Test
	public void isEmptyCollection(){
		Collection<String> collection = new ArrayList<>();
		boolean empty = collection.isEmpty();
		System.out.println(empty);
	}

	/**
	 * 集合装换为数组
	 * 		ArrayList源码注释:c.toArray might (incorrectly) not return Object[] (see 6260652)
	 */
	@Test
	public void toArray(){
		Collection<String> collection = new ArrayList<>();
		collection.add("1");
		collection.add("2");
		collection.add("3");
		Object[] objects = collection.toArray();
		System.out.println(objects.getClass());//class [Ljava.lang.Object;
		System.out.println(Arrays.toString(objects));

		System.out.println("-------------------------");

		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		Object[] listArray = list.toArray();
		System.out.println(listArray.getClass());//class [Ljava.lang.String;
		System.out.println(Arrays.toString(listArray));

		System.out.println("-------------------------");

		List<String> arrayList = Arrays.asList("xxx","yyyy");
		Object[] listArray1 = arrayList.toArray();
		System.out.println(listArray1.getClass());//class [Ljava.lang.Object;
		System.out.println(Arrays.toString(listArray1));
	}
}
