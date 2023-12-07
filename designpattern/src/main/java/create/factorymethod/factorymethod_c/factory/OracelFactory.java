package create.factorymethod.factorymethod_c.factory;

import create.factorymethod.factorymethod_c.service.IUserService;
import create.factorymethod.factorymethod_c.service.UserServiceOracle;

public class OracelFactory extends PersistencecFactory{
    @Override
    public IUserService getOperator() {
        return new UserServiceOracle();
    }
}
