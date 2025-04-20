package create.abstractfactory.abstractfactory_j;

/**
 * xml方式操作主数据库
 * @author ronin
 * @version V1.0
 * @since 2019/9/4 11:38
 */
public class XmlMainDAOImpl implements OrderMainDAO{

    @Override
    public void saveOrderMain() {
        System.out.println("now in XmlMainDAOImpl saveOrderMain");
    }
}
