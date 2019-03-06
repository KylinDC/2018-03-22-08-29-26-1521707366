package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if (leftBorder > rightBorder) {
            int tmp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = tmp;
        }
        return IntStream.rangeClosed(leftBorder, rightBorder).filter(e -> e % 2 == 0).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if (leftBorder > rightBorder) {
            int tmp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = tmp;
        }
        return IntStream.rangeClosed(leftBorder, rightBorder).filter(e -> e % 2 != 0).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(x -> x * 3 + 2).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .map(
                        i -> {
                            if (i % 2 == 0) {
                                return i;
                            } else {
                                return i * 3 + 2;
                            }
                        })
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(e -> e % 2 != 0)
                .map(e -> e * 3 + 5)
                .mapToInt(e -> e.intValue())
                .sum();
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> evens =
                arrayList.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        Collections.sort(evens);
        int medianIndex = evens.size() / 2;
        if (evens.size() % 2 == 0) {
            return (evens.get(medianIndex) + evens.get(medianIndex - 1)) / 2.0;
        }
        return evens.get(medianIndex);
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        return IntStream.range(0, arrayList.size())
                .filter(e -> e % 2 == 0)
                .map(i -> arrayList.get(i))
                .summaryStatistics()
                .getAverage();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElement) {
        return arrayList.stream().filter(e -> e % 2 == 0).anyMatch(e -> e == specialElement);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(e -> e % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evens =
                arrayList.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        List<Integer> odds =
                arrayList.stream().filter(e -> e % 2 != 0).collect(Collectors.toList());
        Collections.reverse(odds);
        evens.addAll(odds);
        return evens;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            result.add((arrayList.get(i) + arrayList.get(i + 1)) * 3);
        }
        return result;
    }
}
