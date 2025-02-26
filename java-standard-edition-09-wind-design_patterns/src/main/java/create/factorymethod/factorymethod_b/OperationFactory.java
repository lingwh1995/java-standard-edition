package create.factorymethod.factorymethod_b;

public abstract class OperationFactory {
    public Double opertion(Double a, Double b){
        Operation operation = createOperation();
        return operation.opertion(a,b);
    }
    protected abstract Operation createOperation();
}
