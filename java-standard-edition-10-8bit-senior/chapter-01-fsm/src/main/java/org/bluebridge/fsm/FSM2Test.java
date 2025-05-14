package org.bluebridge.fsm;

import static org.bluebridge.fsm.STATE.*;

enum STATE{
    BEGIN,
    IN_WORD,
    OUT_WORD,
    END
}

/**
 * 使用枚举作为状态码实现状态机
 */
public class FSM2Test {
    public static void main(String[] args) {
        String s = " one  two   three    four     five ";
        STATE state = BEGIN;
        int wordCount = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            switch (state){
                case BEGIN:
                    if(Character.isLetter(c)) {
                        state = IN_WORD;
                    }else {
                        state = OUT_WORD;
                    }
                    break;
                case IN_WORD:
                    if(!Character.isLetter(c)) {
                        wordCount++;
                        state = OUT_WORD;
                    }
                    break;
                case OUT_WORD:
                    if(Character.isLetter(c)) {
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
