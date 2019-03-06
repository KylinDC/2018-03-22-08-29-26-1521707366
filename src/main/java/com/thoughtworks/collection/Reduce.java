package com.thoughtworks.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        //        return arrayList.stream().mapToInt(e -> e).max().getAsInt();
        return arrayList.stream().max(Integer::compareTo).get();
    }

    public double getMinimum() {
        return arrayList.stream().min(Comparator.comparing(Integer::valueOf)).get();
    }

    public double getAverage() {
        return arrayList.stream().mapToInt(e -> e.intValue()).summaryStatistics().getAverage();
    }

    public double getOrderedMedian() {
        Collections.sort(arrayList);
        int medianIndex = arrayList.size() / 2;
        if (arrayList.size() % 2 == 0) {
            return (arrayList.get(medianIndex) + arrayList.get(medianIndex - 1)) / 2.0;
        }
        return arrayList.get(medianIndex);
    }

    public int getFirstEven() {
        return arrayList.stream().filter(e -> e % 2 == 0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEqual(List<Integer> anotherArrayList) {
        if (arrayList.size() == anotherArrayList.size()) {
            return IntStream.range(0, arrayList.size() - 1)
                    .allMatch(i -> arrayList.get(i) == anotherArrayList.get(i));
        }
        return false;
    }

    // 实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        SingleLinkRealize<Integer> singleLinkRealize = new SingleLinkRealize<>();
        arrayList.stream()
                .forEach(
                        e -> {
                            singleLink.addTailPointer(e);
                            singleLinkRealize.addTailPointer(e);
                        });
        int medianIndex = singleLinkRealize.size() / 2;
        if (singleLinkRealize.size() % 2 == 0) {
            return (singleLinkRealize.getNode(medianIndex)
                            + singleLinkRealize.getNode(medianIndex + 1))
                    / 2.0;
        }
        return singleLinkRealize.getNode(medianIndex).doubleValue();
    }

    public int getLastOdd() {
        List<Integer> odds =
                arrayList.stream().filter(e -> e % 2 != 0).collect(Collectors.toList());
        return odds.get(odds.size() - 1);
    }

    public int getIndexOfLastOdd() {
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) % 2 != 0) {
                return i;
            }
        }
        return -1;
    }
}
