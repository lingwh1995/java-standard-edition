package create.abstractfactory.abstractfactory_d.service;

import create.abstractfactory.abstractfactory_d.domain.Cusomer;

public class CustomerServiceOracle implements ICustomerService {

    @Override
    public Cusomer get(Integer uid) {
        System.out.println("Oracle操作数据库......Customer");
        return new Cusomer();
    }
}
