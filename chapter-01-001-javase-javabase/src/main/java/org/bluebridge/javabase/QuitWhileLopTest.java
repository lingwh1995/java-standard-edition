package org.bluebridge.javabase;

public class QuitWhileLopTest {
    public static void main(String[] args) {
        boolean loop = true;
        int i = 0;
        while(loop){
            System.out.println(i);
            i++;
            if(i == 200){
                loop = false;
            }
        }
    }
}
