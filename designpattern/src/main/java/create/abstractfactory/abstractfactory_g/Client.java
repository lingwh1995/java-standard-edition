package create.abstractfactory.abstractfactory_g;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/4 9:51
 */
public class Client {
    public static void main(String[] args) {
        //创建装机工程师对象
        ComputerEngineer engineer = new ComputerEngineer();
        //告诉装机工程师自己选择的配件，让装机工程师组装电脑
        engineer.makeComputer(1,1);
    }
}
