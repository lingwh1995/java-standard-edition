package create.factorymethod.factorymethod_b;

public class SubFactory extends OperationFactory{
    @Override
    protected Operation createOperation() {
        System.out.println("减法操作工厂...");
        return new Sub();
    }
}
