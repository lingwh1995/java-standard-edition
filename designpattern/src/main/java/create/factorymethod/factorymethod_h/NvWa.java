package create.factorymethod.factorymethod_h;



public class NvWa {
    public void showSkinColor(String targetSkinColor){
        Human human = createHuman(targetSkinColor);
        String skinColor = human.skinColor;
        System.out.println("skinColor:"+skinColor);
    }
    Human createHuman(String skinColor) {
        Human human = null;
        if("white".equals(skinColor)){
            human = new WhiteHuman();
        }
        if("yellow".equals(skinColor)){
            human = new YellowHuman();
        }
        if("black".equals(skinColor)){
            human = new BlackHuman();
        }
        return human;
    }
}
