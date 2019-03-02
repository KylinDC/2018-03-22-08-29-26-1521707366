package com.thoughtworks.collection;

import java.util.*;

public class Filter {

    List<Integer> array;

    public Filter(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> filterEven() {
        List<Integer> result = new ArrayList<>();
        for (int element : array) {
            if (element % 2 == 0) {
                result.add(element);
            }
        }
        return result;
    }

    public List<Integer> filterMultipleOfThree() {
        List<Integer> result = new ArrayList<>();
        for (int element : array) {
            if (element % 3 == 0) {
                result.add(element);
            }
        }
        return result;
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> commons = new ArrayList<>();
        for (int element : firstList) {
            if (secondList.contains(element)) {
                commons.add(element);
            }
        }
        return commons;
    }

    public List<Integer> getDifferentElements() {
        Set<Integer> evensSet = new HashSet<>(array);
        return new ArrayList<Integer>(evensSet);
    }
}
