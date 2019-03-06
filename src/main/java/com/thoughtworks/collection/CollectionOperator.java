package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        Boolean isRightBigger = right > left ? true : false;
        if (!isRightBigger) {
            int temp = right;
            right = left;
            left = temp;
        }
        List<Integer> result =
                IntStream.rangeClosed(left, right).boxed().collect(Collectors.toList());
        if (!isRightBigger) {
            Collections.reverse(result);
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        return getListByInterval(left, right).stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).filter(i -> i % 2 == 0).boxed().collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return Arrays.stream(array).reduce((first, second) -> second).getAsInt();
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> secondList = Arrays.stream(secondArray).boxed().collect(Collectors.toList());
        return Arrays.stream(firstArray)
                .boxed()
                .filter(e -> secondList.contains(e))
                .collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = new ArrayList<>(Arrays.asList(firstArray));
        firstList.addAll(Arrays.asList(secondArray));
        return firstList.stream().distinct().collect(Collectors.toList());
    }
}
