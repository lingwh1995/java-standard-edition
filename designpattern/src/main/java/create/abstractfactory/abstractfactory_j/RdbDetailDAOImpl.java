package create.abstractfactory.abstractfactory_j;

/**
 * 关系型数据库操作子订单
 * @author ronin
 * @version V1.0
 * @since 2019/9/4 11:37
 */
public class RdbDetailDAOImpl implements OrderDetailDAO{

    @Override
    public void saveOrderDetail() {
        System.out.println("now in RdbDetailDAOImpl saveOrderDetail");
    }
}
