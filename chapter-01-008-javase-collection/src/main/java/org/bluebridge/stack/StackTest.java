package org.bluebridge.stack;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println(stack);

        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack);

        Integer peek1 = stack.peek();
        System.out.println("peek1:"+peek1);
        Integer peek2 = stack.peek();
        System.out.println("peek2:"+peek2);
        System.out.println(stack);

        Integer pop1 = stack.pop();
        System.out.println("pop1:"+pop1);
        System.out.println(stack);
        Integer pop2 = stack.pop();
        System.out.println("pop2:"+pop2);
        System.out.println(stack);

        System.out.println("stack.get(0):" +stack.get(0));
        System.out.println("stack.get(1):" + stack.get(1));

        //遍历
        while(stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
