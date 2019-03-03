package com.thoughtworks.collection;

import java.util.*;

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
        List<Integer> result = new ArrayList<>();
        for (int element : array) {
            result.add(element * 3);
        }
        return result;
    }

    public String decToLetter(int num) {
        if (num <= 26) {
            return letters[num - 1];
        } else {
            return decToLetter((int) Math.floor((num - 1) / 26)) + letters[((num - 1) % 26)];
        }
    }

    public List<String> mapLetter() {
        List<String> result = new ArrayList<>();
        for (int element : array) {
            result.add(decToLetter(element));
        }
        return result;
    }

    public List<String> mapLetters() {
        List<String> result = new ArrayList<>();
        for (int element : array) {
            result.add(decToLetter(element));
        }
        return result;
    }

    public List<Integer> sortFromBig() {
        Comparator descendingSort =
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (o2 > o1) {
                            return 1;
                        }
                        return -1;
                    }
                };
        Collections.sort(array, descendingSort);
        return array;
    }

    public List<Integer> sortFromSmall() {
        Collections.sort(array);
        return array;
    }
}
