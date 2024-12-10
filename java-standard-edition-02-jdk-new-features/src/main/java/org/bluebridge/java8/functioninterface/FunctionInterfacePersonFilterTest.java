package org.bluebridge.java8.functioninterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * 需求:
 *      把username=zhangsan的Person放入到新集合中
 * @author ronin
 */
public class FunctionInterfacePersonFilterTest {
    public static void main(String[] args) {
        Person zhangsan = new Person("zhangsan", 18);
        Person ls = new Person("ls", 28);
        Person ww = new Person("ww", 38);
        List<Person> persons = Arrays.asList(zhangsan, ls, ww);
        List<Person> elements = getUserByName(persons, "ls");
        elements.forEach(person -> System.out.println(person));
        System.out.println("----------------------------------");
        List<Person> elementsOfage = getUserByAge(persons, 19);
        elementsOfage.forEach(person -> System.out.println(person));
        System.out.println("----------------------------------");
        List<Person> elementsOfUsername = getUserByUsername(persons, "ww", (personList, username) ->
                personList.stream().filter(person -> person.getUsername().equals(username)).
                        collect(Collectors.toList()));
        elementsOfUsername.forEach(person -> System.out.println(person));
    }

    /**
     * 根据username获取对应的Person
     * @param persons
     * @param username
     * @return
     */
    public static List<Person> getUserByName(List<Person> persons,String username){
        return persons.stream().filter(person->person.getUsername().equals(username)).
                collect(Collectors.toList());
    }

    /**
     * 根据age获取对应的Person
     * @param persons
     * @param age
     * @return
     */
    public static List<Person> getUserByAge(List<Person> persons,Integer age){
        /**
         * 写法一:statement格式
         */
//        BiFunction<Integer,List<Person>,List<Person>> biFunction = (ageOfPerson,personList) -> {
//            return persons.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());
//        };

        /**
         * 写法二:expression形式
         */
        BiFunction<Integer,List<Person>,List<Person>> biFunction = (ageOfPerson,personList) ->
            persons.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());
        return biFunction.apply(age,persons);
    }

    public static List<Person> getUserByUsername(List<Person> persons,String username,BiFunction<List<Person>,String,List<Person>> function){
        return function.apply(persons,username);
    }
}
