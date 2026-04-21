package create.builder.builder_b;

public abstract class AbstractHouseBuilder {
    protected House house = new House();

    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void buildRoof();

    public House buildHouse(){
        buildBasic();
        buildWalls();
        buildRoof();
        return house;
    }
}
