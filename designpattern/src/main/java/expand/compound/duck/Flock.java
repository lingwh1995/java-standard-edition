package expand.compound.duck;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/10/10 13:22
 */
public class Flock implements Quackable{
    ArrayList quackers = new ArrayList<>();

    public void add(Quackable quacker){
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        Iterator<Quackable> iterator = quackers.iterator();
        while(iterator.hasNext()){
            Quackable quacker = iterator.next();
            quacker.quack();
        }
    }
}
