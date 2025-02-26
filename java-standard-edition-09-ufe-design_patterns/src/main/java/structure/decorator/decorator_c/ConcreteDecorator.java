package structure.decorator.decorator_c;

public class ConcreteDecorator extends Decorator{
    public ConcreteDecorator(Component component) {
        this.component = component;
    }
    public void operation() {
        component.operation();
        addedFunction();
    }
    public void addedFunction() {
        System.out.println("为具体构件角色增加额外的功能addedFunction()");
    }
}
