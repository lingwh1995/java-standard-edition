package structure.facade.facade_c;

/**
 * 代码生成子系统的外观对象
 * @author ronin
 * @version V1.0
 * @since 2019/9/12 11:01
 */
public class Facade {

    /**
     * 生成代码
     */
    public void generate(){
        new Presentation().generate();
        new Business().generate();
        new DAO().generate();
    }
}
