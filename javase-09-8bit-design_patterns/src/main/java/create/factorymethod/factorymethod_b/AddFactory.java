package create.factorymethod.factorymethod_b;

public class AddFactory extends OperationFactory{
    @Override
    protected Operation createOperation() {
        System.out.println("加法操作工厂...");
        return new Add();
    }
}
