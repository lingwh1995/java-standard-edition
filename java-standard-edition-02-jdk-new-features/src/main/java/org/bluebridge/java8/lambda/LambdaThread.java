package org.bluebridge.java8.lambda;

/**
 * @author ronin
 */
public class LambdaThread {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("Thread1 is running......")).start();
        new Thread(()-> {System.out.println("Thread2 is running......");}).start();
    }
}
