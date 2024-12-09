package org.bluebridge.collection;

import java.util.*;

import org.junit.Test;

/**
 * @author ronin
 */
public class CollectionTest {
	
	/**
	 * 测试addAll()
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
	 * 测试removeAll()
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
	 * 测试contains()和containsAll()
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
	
    public static void main(String[] args) {
        Collection<String> c9 = new ArrayList<>();
        c9.add("a");
        c9.add("b");
        c9.add("c");
        Collection<String> c10 = new ArrayList<>();
        c10.add("b");
        Collection<String> c11 = new ArrayList<>();
        c11.add("a");
        c11.add("b");
        c11.add("c");
        Collection<String> c12 = new ArrayList<>();
        c12.add("d");
        c12.add("e");
        //A与B做交集，交集的值保存在A中，方法执行完成后,如果A的值发生了改变,则返回true，如果A的值没发生改变,则返回false
        System.out.println(c9.retainAll(c10));
        System.out.println(c9);
        System.out.println(c11.retainAll(c12));
        System.out.println(c11);


        //使用for循环遍历集合
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        for(Iterator<String> iterator = list.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
        list.clear();
        System.out.println("调用了clear():"+list);

        Collection<String> c13 = new ArrayList<>();
        c13.add("d");
        c13.add("e");
        System.out.println(Arrays.toString(c13.toArray()));

        System.out.println("---------------------------------");
        List<String> c14 = new ArrayList<String>();
        c14.add("a");
        c14.add("b");
        //contains(Object object)底层是Object类的equals()方法
        System.out.println(c14.contains("a"));
    }
}
