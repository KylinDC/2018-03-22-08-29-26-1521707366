package com.thoughtworks.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters =
            new String[] {
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
                "r", "s", "t", "u", "v", "w", "x", "y", "z"
            };
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(e -> e * 3).collect(Collectors.toList());
    }

    public String decToLetter(int num) {
        if (num <= 26) {
            return letters[num - 1];
        } else {
            return decToLetter((int) Math.floor((num - 1) / 26)) + letters[((num - 1) % 26)];
        }
    }

    public List<String> mapLetter() {
        return array.stream().map(e -> decToLetter(e)).collect(Collectors.toList());
    }

    public List<String> mapLetters() {
        return array.stream().map(e -> decToLetter(e)).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
