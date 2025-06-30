package org.bluebridge.set;

import java.util.HashSet;

/**
 * HashSet保证元素唯一性:调用hashSet.add(E e)时底层依赖hashCode()和equals()方法
 *      如果是对象类型元素需要重写hashCode()和equals()方法
 * HashSet如何保证元素唯一性:
 *      先调用hashCode()方法,hashCode相同,然后根据equals()方法判断
 * 注意:Set保证元素唯一性不适用于引用类型,对于引用类型
 *      HashSet:重写equals()和hashCode()方法
 *      HashTable:使用Comparator或者Comparable保证实现元素唯一性
 * @author ronin
 */
public class HashSetTest {
    public static void main(String[] args) {
        Student s1 = new Student("zs", "18");
        Student s2 = new Student("zs", "18");
        Student s3 = new Student("ls", "18");

        HashSet<Student> students = new HashSet<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        for (Student student:students){
            System.out.println(student);
        }
    }

}

class Student{
    private String name;
    private String school;

    public Student(String name, String school) {
        this.name = name;
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student student = (Student) o;

        if (name != null ? !name.equals(student.name) : student.name != null) {
            return false;
        }
        return school != null ? school.equals(student.school) : student.school == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (school != null ? school.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
