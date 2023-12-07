package action.visitor.visitor_b;

public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
