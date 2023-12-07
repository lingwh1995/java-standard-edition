package expand.compound.duck;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/10 10:22
 */
public class QuackCounter implements Quackable{
    private Quackable quackable;
    private static int numberOfQuacks = 0;

    public QuackCounter(Quackable quackable) {
        this.quackable = quackable;
    }

    @Override
    public void quack() {
        quackable.quack();
        numberOfQuacks++;
    }

    /**
     * 获取鸭子总共鸣叫次数
     * @return
     */
    public static int getQuackCount() {
        return numberOfQuacks;
    }
}
