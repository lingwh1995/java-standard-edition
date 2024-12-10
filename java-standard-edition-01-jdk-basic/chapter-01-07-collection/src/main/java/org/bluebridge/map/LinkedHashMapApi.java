package org.bluebridge.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap:保证键的唯一性并且有序
 *      由hash表保证键的唯一性,由链表保证键的有序性
 * @author ronin
 */
public class LinkedHashMapApi {
    public static void main(String[] args) {
        Map<Door,String> pigMap = new LinkedHashMap<>();
        pigMap.put(new Door("aa",18),"1");
        pigMap.put(new Door("bb",28),"2");
        pigMap.put(new Door("cc",38),"3");
        pigMap.put(new Door("aa",18),"4");
        System.out.println(pigMap);
    }
}
class Door {
    private String name;
    private Integer age;

    public Door(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Door door = (Door) o;

        if (name != null ? !name.equals(door.name) : door.name != null) {
            return false;
        }
        return age != null ? age.equals(door.age) : door.age == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Door{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
