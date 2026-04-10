package create.factorymethod.factorymethod_h;

public class YellowHumanCreator extends HumanCreator {
    @Override
    Human createHuman() {
        return new YellowHuman();
    }
}
