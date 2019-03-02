package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class Flaten {

    Integer[][] array;

    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> result = new ArrayList<>();
        for (Integer[] element : array) {
            for (Integer i : element) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> result = new ArrayList<>();
        for (Integer[] element : array) {
            for (Integer i : element) {
                result.add(i);
            }
        }
        return new ArrayList<Integer>(new LinkedHashSet<Integer>(result));
    }
}
