package create.abstractfactory.abstractfactory_c.factory;

import create.abstractfactory.abstractfactory_c.service.CustomerServiceMysql;
import create.abstractfactory.abstractfactory_c.service.ICustomerService;
import create.abstractfactory.abstractfactory_c.service.IUserService;
import create.abstractfactory.abstractfactory_c.service.UserServiceMysql;

public class MysqlFactory implements PersistencecFactory {
    @Override
    public IUserService getUserOperator() {
        return new UserServiceMysql();
    }

    @Override
    public ICustomerService getCustomerOperator() {
        return new CustomerServiceMysql();
    }
}
