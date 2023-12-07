package action.iterator.iterator_l;

import java.util.Iterator;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/23 10:47
 */
public class Client {
    public static void main(String[] args) {
        ListStructure listStructure = new ListStructure();
        listStructure.addElement(new Person("zs",18));
        listStructure.addElement(new Person("ls",28));
        listStructure.addElement(new Person("ww",38));
        Iterator<Person> iterator = listStructure.iterator();
        while (iterator.hasNext()){
            Person person = iterator.next();
            System.out.println(person);
        }
    }
}
