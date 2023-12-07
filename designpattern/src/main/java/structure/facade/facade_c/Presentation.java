package structure.facade.facade_c;

/**
 * 示意生成表现层的模块
 * @author ronin
 * @version V1.0
 * @since 2019/9/12 8:53
 */
public class Presentation {
    public void generate(){
        //1：从配置管理里面获取相应的配置信息
        ConfigModel cm = ConfigManager.getInstance().getConfigData();
        if(cm.isNeedGenPresentation()){
            //2：按照要求去生成相应的代码，并保存成文件
            System.out.println("正在生成表现层代码文件");
        }
    }
}
