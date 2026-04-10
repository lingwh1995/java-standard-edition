package structure.decorator.decorator_c;

public abstract class Decorator implements Component{
    protected Component component;

    public abstract void operation();
}
