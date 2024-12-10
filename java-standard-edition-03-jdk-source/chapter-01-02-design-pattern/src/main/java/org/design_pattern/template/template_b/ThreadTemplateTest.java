package org.design_pattern.template.template_b;

/**
 * @author ronin
 */
public class ThreadTemplateTest {
    public static void main(String[] args) {
        ThreadTemplate tm = new ThreadTemplate(){
            @Override
            public void run() {
                System.out.println("线程启动了......");
            }
        };
        tm.start();
    }
}
