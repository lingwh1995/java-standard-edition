package org.bluebridge.fsm;

/**
 * 有限状态机，又称有限状态自动机，简称状态机
 *
 * 使用常量作为状态码实现状态机
 */
public class FSM1Test {
    private static final int BEGIN = 0;
    private static final int IN_WORD = 1;
    private static final int OUT_WORD = 2;
    private static final int END = 3;

    public static void main(String[] args) {
        String s = " one  two   three    four     five ";
        int wordCount = 0;
        int state = BEGIN;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            System.out.println("c = " + c + ",state = " + state);
            switch (state){
                case BEGIN:
                    if(Character.isLetter(c)){
                        state = IN_WORD;
                    }else {
                        state = OUT_WORD;
                    }
                    break;
                case IN_WORD:
                    if(!Character.isLetter(c)){
                        wordCount++;
                        state = OUT_WORD;
                    }
                    break;
                case OUT_WORD:
                    if(Character.isLetter(c)){
                        state = IN_WORD;
                    }
                    break;
            }
        }
        if(state == IN_WORD) {
            wordCount++;
        }
        state = END;
        System.out.println("单词数量 = " + wordCount);
        System.out.println("状态机状态 = " + state);
    }
}
