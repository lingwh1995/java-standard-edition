package org.bluebridge.unsafe_04_object_operate;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;

    public Student() {
        this.name = "张三";
    }
}
