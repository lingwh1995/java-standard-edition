package create.factorymethod.factorymethod_c.factory;

import create.factorymethod.factorymethod_c.service.IUserService;

public abstract class PersistencecFactory {
    public void operate(Integer id){
        IUserService operator = getOperator();
        operator.get(id);
    }
    abstract IUserService getOperator();
}
