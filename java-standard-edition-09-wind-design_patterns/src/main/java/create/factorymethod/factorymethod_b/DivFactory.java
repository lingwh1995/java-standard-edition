package create.factorymethod.factorymethod_b;


public class DivFactory extends OperationFactory{
    @Override
    protected Operation createOperation() {
        System.out.println("除法操作工厂...");
        return new Div();
    }
}
