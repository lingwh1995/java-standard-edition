package org.bluebridge.other;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Vector集合特有的方法:
 *      elements()
 *      hasMoreElements
 *      nextElement
 *      elementAt
 * @author ronin
 */
public class VectorTest {
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("a");
        vector.add("b");
        vector.add("c");
        System.out.println(vector);
        System.out.println("-----------------------------------");
        System.out.println(vector.elementAt(1));
        System.out.println("-----------------------------------");
        Enumeration<String> elements = vector.elements();
        while (elements.hasMoreElements()){
            System.out.println(elements.nextElement());
        }
    }
}
