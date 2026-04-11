package structure.adapter.adapter_m;

public class AnnotationHandlerAdapter implements HandlerAdapter {

    @Override
    public void handle(Object handler) {
        ((AnnotationController)handler).doAnnotationHandler();
    }

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof AnnotationController);
    }

}
