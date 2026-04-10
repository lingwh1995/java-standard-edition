package action.iterator.iterator_l;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/23 10:40
 */
public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
