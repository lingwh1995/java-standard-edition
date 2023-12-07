package create.simplefactory.simplefactory_e;

public class Client {
    public static void main(String[] args) {
        HumanCreator humanCreator = new HumanCreator();
        Human yellowHumanSkinColor = humanCreator.createHuman("yellow");
        Human blackHumanSkinColor = humanCreator.createHuman("black");
        Human whiteHumanSkinColor = humanCreator.createHuman("white");
        System.out.println("yellowHumanSkinColor:"+yellowHumanSkinColor.skinColor);
        System.out.println("blackHumanSkinColor:"+blackHumanSkinColor.skinColor);
        System.out.println("whiteHumanSkinColor:"+whiteHumanSkinColor.skinColor);
    }
}
