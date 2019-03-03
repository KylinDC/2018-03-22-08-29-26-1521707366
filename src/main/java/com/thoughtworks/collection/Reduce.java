package com.thoughtworks.collection;

import java.util.*;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        TreeSet<Integer> treeSet = new TreeSet<>(arrayList);
        return treeSet.last();
    }

    public double getMinimum() {
        TreeSet<Integer> treeSet = new TreeSet<>(arrayList);
        return treeSet.first();
    }

    public double getAverage() {
        int sum = 0;
        for (int element : arrayList) {
            sum += element;
        }
        return (double) sum / arrayList.size();
    }

    public double getOrderedMedian() {
        Collections.sort(arrayList);
        float middenIndex = (float) arrayList.size() / 2;
        int middenLeft = arrayList.get((int) Math.ceil(middenIndex) - 1);
        int middenRight = arrayList.get((int) Math.floor(middenIndex));
        return (double) (middenLeft + middenRight) / 2;
    }

    public int getFirstEven() {
        for (int element : arrayList) {
            if (element % 2 == 0) {
                return element;
            }
        }
        return -1;
    }

    public int getIndexOfFirstEven() {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 == 0) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.equals(arrayList);
    }

    //     实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        SingleLinkRealize<Integer> singleLinkRealize = new SingleLinkRealize<>();
        for (int i : arrayList) {
            singleLink.addTailPointer(i);
            singleLinkRealize.addTailPointer(i);
        }
        int medianLeft =
                (int) singleLinkRealize.getNode((int) Math.floor(singleLinkRealize.size() / 2));
        int medianRight =
                (int) singleLinkRealize.getNode((int) Math.floor(singleLinkRealize.size() / 2) + 1);
        return (medianLeft + medianRight) / 2.0;
    }

    public int getLastOdd() {
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) % 2 != 0) {
                return arrayList.get(i);
            }
        }
        return -1;
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
