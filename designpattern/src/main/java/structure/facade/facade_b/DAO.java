package structure.facade.facade_b;

/**
 * 示意生成数据层的模块
 * @author ronin
 * @version V1.0
 * @since 2019/9/12 8:54
 */
public class DAO {
    public void generate(){
        ConfigModel cm = ConfigManager.getInstance().getConfigData();
        if(cm.isNeedGenDAO()){
            System.out.println("正在生成数据层代码文件");
        }
    }
}
