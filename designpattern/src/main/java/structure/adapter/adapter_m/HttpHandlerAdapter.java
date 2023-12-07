package structure.adapter.adapter_m;

public class HttpHandlerAdapter implements HandlerAdapter {

    @Override
    public void handle(Object handler) {
        ((HttpController)handler).doHttpHandler();
    }

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof HttpController);
    }
}
