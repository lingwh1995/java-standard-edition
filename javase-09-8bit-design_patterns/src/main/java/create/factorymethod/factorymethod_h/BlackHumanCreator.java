package create.factorymethod.factorymethod_h;

public class BlackHumanCreator extends HumanCreator {
    @Override
    Human createHuman() {
        return new BlackHuman();
    }
}
