package create.factorymethod.factorymethod_b;

public class MulFactory extends OperationFactory{
    @Override
    protected Operation createOperation() {
        System.out.println("乘法工厂类...");
        return new Mul();
    }
}
