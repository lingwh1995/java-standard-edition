package expand.compound.duck;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/10 9:57
 */
public class GooseAdapter implements Quackable{
    private Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }


}
