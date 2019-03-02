package com.thoughtworks.collection;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int step = left - right > 0 ? -1 : 1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= Math.abs(left - right); i++) {
            result.add(left + step * i);
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        int step = left - right >= 0 ? -1 : 1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= Math.abs(left - right); i++) {
            int num = left + step * i;
            if ((num) % 2 == 0) {
                result.add(num);
            }
        }
        return result;
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> evens = new ArrayList<>();
        for (int element : array) {
            if (element % 2 == 0) {
                evens.add(element);
            }
        }
        return evens;
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> commons = new ArrayList<>();
        for (int firstElement : firstArray) {
            for (int secondElement : secondArray) {
                if (firstElement == secondElement) {
                    commons.add(firstElement);
                }
            }
        }
        return commons;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> result = new ArrayList<>(Arrays.asList(firstArray));
        for (int element : secondArray) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
}
