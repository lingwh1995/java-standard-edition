package create.builder.builder_d;

public class Client {
    public static void main(String[] args) {
        //盖普通房子
        CommonHouseBuilder commonHouseBuilder = new CommonHouseBuilder();
        //创建指挥者
        House commonHouse = commonHouseBuilder.build();
        System.out.println(commonHouse);


        System.out.println("---------------------------");
        //盖高楼大厦
        HighHouseBuilder highHouseBuilder = new HighHouseBuilder();
        //重置建造者
        House highHouse = highHouseBuilder.build();
        System.out.println(highHouse);
    }
}
