package org.bluebridge.beginner;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 比较器接口
 */
public class ComparatorTest {

    @Test
    public void testComparator() {
        //创建数组
        User[] users = new User[3];
        users[0] = new User("张三",28);
        users[1] = new User("李四",18);
        users[2] = new User("王五",30);

        //数组排序
        Arrays.sort(users,new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(Arrays.toString(users));
    }
}

@Data
@AllArgsConstructor
class User {
    private String name;
    private Integer age;
}