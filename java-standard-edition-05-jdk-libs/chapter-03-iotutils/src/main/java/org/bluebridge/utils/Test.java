package org.bluebridge.utils;

public class Test {
    public static void main(String[] args) {
        String s = " hello  c   lang    nice ";
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            switch (c){
                case 'A':
                    s = s.replace(" ", "");
                    break;
                case 'B':
                    break;
            }
        }
    }
}
