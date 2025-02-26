package create.factorymethod.factorymethod_h;

public class Client {
    public static void main(String[] args) {
        HumanCreator yellowHumanCreator = new YellowHumanCreator();
        yellowHumanCreator.showSkinColor();
        HumanCreator blackHumanCreator = new BlackHumanCreator();
        blackHumanCreator.showSkinColor();
        HumanCreator whitewHumanCreator = new WhiteHumanCreator();
        whitewHumanCreator.showSkinColor();

        System.out.println("-------------------------------------");
        NvWa nvWa = new NvWa();
        nvWa.showSkinColor("yellow");
        nvWa.showSkinColor("black");
        nvWa.showSkinColor("white");
    }
}
