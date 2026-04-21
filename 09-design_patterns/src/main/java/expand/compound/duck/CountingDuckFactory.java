package expand.compound.duck;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/10 11:23
 */
public class CountingDuckFactory extends AbstractDuckFactory{
    @Override
    Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    Quackable createRedHeadDuck() {
        return new QuackCounter(new RedHeadDuck());
    }

    @Override
    Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }

    @Override
    Quackable createDuckcall() {
        return new QuackCounter(new DuckCall());
    }
}
