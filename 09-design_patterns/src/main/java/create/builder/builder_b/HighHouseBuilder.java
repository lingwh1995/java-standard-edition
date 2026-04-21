package create.builder.builder_b;

public class HighHouseBuilder extends AbstractHouseBuilder{
    @Override
    public void buildBasic() {
        house.setBasic("地基50米");
        System.out.println("高楼大厦地基50米......");
    }

    @Override
    public void buildWalls() {
        house.setWalls("围墙40公分");
        System.out.println("高楼大厦围墙40公分......");
    }

    @Override
    public void buildRoof() {
        house.setRoof("屋顶三层");
        System.out.println("高楼大厦屋顶有三层.......");
    }
}
