package create.builder.builder_d;

/**
 * 抽象的建造者
 */
public abstract class HouseBuilder {
    protected House house = new House();
    //地基
    public abstract void buildBasic();
    //墙面
    public abstract void buildWalls();
    //屋顶
    public abstract void buildRoof();

    /**
     * 如何建造房子交给指挥者，并且把Director的功能加入到抽象构建者
     * @return
     */
    public House build(){
        this.buildBasic();
        this.buildWalls();
        this.buildRoof();
        return house;
    }
}
