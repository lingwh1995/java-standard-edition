package methodreference;

/**
 * @author ronin
 */
public class PersonComparator {
    public static int compareStatic(Person p1,Person p2){
        return p2.getAge() - p1.getAge();
    }

    public int compareNoStatic(Person p1,Person p2){
        return p2.getAge() - p1.getAge();
    }
}
