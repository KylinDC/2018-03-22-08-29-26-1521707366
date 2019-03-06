package com.thoughtworks.collection;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        int randomNum = random.nextInt(3);
        return Stream.iterate(number - randomNum, i -> i - randomNum)
                .limit(number / randomNum)
                .collect(Collectors.toList());
    }
}
