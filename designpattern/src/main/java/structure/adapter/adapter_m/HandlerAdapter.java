package structure.adapter.adapter_m;

public interface HandlerAdapter {
    boolean supports(Object handler);
    void handle(Object handler);
}


