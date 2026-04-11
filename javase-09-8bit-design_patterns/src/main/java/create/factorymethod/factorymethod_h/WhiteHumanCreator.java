package create.factorymethod.factorymethod_h;

public class WhiteHumanCreator extends HumanCreator {
    @Override
    Human createHuman() {
        return new WhiteHuman();
    }
}
