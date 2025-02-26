package structure.adapter.adapter_d;

import structure.adapter.adapter_c.AbstractAnimateListenerAdpater;

public class Client {
    public static void main(String[] args) {
        AnimateListener listener = new AnimateOnStart();
        listener.onAnimateStart();
    }
}
