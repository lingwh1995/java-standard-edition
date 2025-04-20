package stack.stack_b;

import org.junit.Test;


public class LinkedListStackTest {

    @Test
    public void fun(){
        LinkedListStack stack = new LinkedListStack();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.show();
        System.out.println("size:" + stack.size());
        System.out.println("pop:" + stack.pop());
        stack.show();
        System.out.println("pop:" + stack.pop());
        stack.show();
        System.out.println("pop:" + stack.pop());
        stack.show();
    }

}
