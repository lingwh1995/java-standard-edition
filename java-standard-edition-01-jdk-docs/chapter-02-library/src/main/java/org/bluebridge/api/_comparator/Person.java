package org.bluebridge.api._comparator;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Person implements Comparable<Person>{
    private String name;
    private int age;

    /**
     * 比较两个Person是否相等：若它们的name和age都相等，则认为它们相等
     */
    boolean equals(Person person) {
        if (this.age == person.age && this.name == person.name)
            return true;
        return false;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

}
