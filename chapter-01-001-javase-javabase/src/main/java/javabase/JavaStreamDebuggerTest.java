package javabase;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaStreamDebuggerTest {
    public static void main(String[] args) {
        List<int[]> collect = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
                        .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)})).collect(Collectors.toList());
    }
}
