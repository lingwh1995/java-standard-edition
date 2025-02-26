package create.abstractfactory.abstractfactory_c.factory;

/**
 * 简单工厂和抽象工厂模式
 */
public class EasyPersistenceFactory {
    public static PersistencecFactory getOperator(Class clazz) throws IllegalAccessException, InstantiationException {
        return (PersistencecFactory) clazz.newInstance();
    }
}
