package create.abstractfactory.abstractfactory_j;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/4 13:13
 */
public class XmlDAOFactory extends DAOFactory {

    @Override
    public OrderDetailDAO createOrderDetailDAO() {
        return new XmlDetailDAOImpl();
    }

    @Override
    public OrderMainDAO createOrderMainDAO() {
        return new XmlMainDAOImpl();
    }
}
