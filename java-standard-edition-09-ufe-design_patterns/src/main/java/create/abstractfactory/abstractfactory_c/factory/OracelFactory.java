package create.abstractfactory.abstractfactory_c.factory;

import create.abstractfactory.abstractfactory_c.service.CustomerServiceOracle;
import create.abstractfactory.abstractfactory_c.service.ICustomerService;
import create.abstractfactory.abstractfactory_c.service.IUserService;
import create.abstractfactory.abstractfactory_c.service.UserServiceOracle;

public class OracelFactory implements PersistencecFactory {
    @Override
    public IUserService getUserOperator() {
        return new UserServiceOracle();
    }

    @Override
    public ICustomerService getCustomerOperator() {
        return new CustomerServiceOracle();
    }
}
