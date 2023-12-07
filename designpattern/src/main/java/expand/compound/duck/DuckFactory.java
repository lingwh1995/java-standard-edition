package expand.compound.duck;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/10 11:19
 */
public class DuckFactory extends AbstractDuckFactory{
    @Override
    Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    Quackable createRedHeadDuck() {
        return new RedHeadDuck();
    }

    @Override
    Quackable createRubberDuck() {
        return new RubberDuck();
    }

    @Override
    Quackable createDuckcall() {
        return new DuckCall();
    }
}
