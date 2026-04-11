package org.bluebridge.thread.thread_designpattern.threadlocal_storage.threadlocal_storage_b;

/**
 * @author ronin
 */
public class ActionContext {

    private static final ThreadLocal<Context> threadLocal = new ThreadLocal<Context> (){
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    public static class ContextHolder {
        private final static ActionContext context = new ActionContext();
    }

    public static ActionContext getInstance(){
        return ContextHolder.context;
    }

    public Context getContext(){
        return threadLocal.get();
    }

    public void remove() {
        threadLocal.remove();
    }
}
