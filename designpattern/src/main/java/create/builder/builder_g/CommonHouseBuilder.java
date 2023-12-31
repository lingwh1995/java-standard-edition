package create.builder.builder_g;

/**
 * 具体的建造者
 */
public class CommonHouseBuilder extends HouseBuilder {

    @Override
    public void buildBasic() {
        super.house.setBasic("普通房子地基......");
        System.out.println("建造普通房子地基......");
    }

    @Override
    public void buildWalls() {
        super.house.setWalls("普通房子墙壁......");
        System.out.println("建造普通房子墙壁......");
    }

    @Override
    public void buildRoof() {
        super.house.setRoof("普通房子屋顶......");
        System.out.println("建造普通房子屋顶......");
    }

    @Override
    public House build() {
        this.buildBasic();
        this.buildWalls();
        this.buildRoof();
        return house;
    }
}
