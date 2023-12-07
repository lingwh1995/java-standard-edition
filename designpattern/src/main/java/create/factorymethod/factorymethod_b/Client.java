package create.factorymethod.factorymethod_b;

public class Client {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        OperationFactory addFactory = new AddFactory();
        OperationFactory subFactory = new SubFactory();
        OperationFactory divFactory = new DivFactory();
        OperationFactory mulFactory = new MulFactory();

        System.out.println(addFactory.opertion(1.1,2.0));
        System.out.println(subFactory.opertion(1.1,2.0));
        System.out.println(divFactory.opertion(1.1,2.0));
        System.out.println(mulFactory.opertion(1.1,2.0));
    }
}
