package org.bluebridge.list;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author ronin
 */
public class ReallyRandom {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> repository = new ArrayList<>();
        while (repository.size() < 10) {
            int i = random.nextInt(20);
            if(!repository.contains(i)) {
                repository.add(i);
            }
        }
        System.out.println(repository);
    }
}
