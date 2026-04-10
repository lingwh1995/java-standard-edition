package create.factorymethod.factorymethod_h;

public abstract class HumanCreator {
    /**
     * 工厂方法
     * @return
     */
    abstract Human createHuman();
    public void showSkinColor(){
        Human human = createHuman();
        String skinColor = human.skinColor;
        System.out.println("skinColor:"+skinColor);
    }
}
