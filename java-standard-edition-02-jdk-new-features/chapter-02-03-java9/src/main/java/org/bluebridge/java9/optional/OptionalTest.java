package org.bluebridge.java9.optional;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class OptionalTest {

    /**
     * java9中Optional提供了一个将Optional对象转换为Stream流的方法
     */
    @Test
    public void testOptionalStream() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Optional<ArrayList<String>> listOptional = Optional.ofNullable(list);
        Stream<ArrayList<String>> stream = listOptional.stream();
        stream.flatMap(x -> x.stream()).forEach(System.out::println);
    }
}
