package org.design_pattern.template.template_b;

/**
 * @author ronin
 */
public abstract class ThreadTemplate {

    public final void start(){
        System.out.println("-------------------");
        run();
        System.out.println("-------------------");
    }

    protected abstract void run();
}
