package create.abstractfactory.abstractfactory_g;

/**
 * 技嘉的主板
 * @author ronin
 * @version V1.0
 * @since 2019/9/4 9:47
 */
public class GAMainboard implements MainboardApi{

    /**
     * CPU插槽的孔数
     */
    private int cpuHoles = 0;

    /**
     * 构造方法，传入CPU插槽的孔数
     * @param cpuHoles CPU插槽的孔数
     */
    public GAMainboard(int cpuHoles){
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        System.out.println("now in GAMainboard,cpuHoles="+cpuHoles);
    }
}
