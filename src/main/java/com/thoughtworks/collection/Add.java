package com.thoughtworks.collection;

import java.util.*;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if (rightBorder < leftBorder) {
            int temp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = temp;
        }
        int startBorder = leftBorder % 2 == 0 ? leftBorder : leftBorder + 1;
        int sum = 0;
        for (int i = startBorder; i <= rightBorder; i += 2) {
            sum += i;
        }
        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if (rightBorder < leftBorder) {
            int temp = leftBorder;
            leftBorder = rightBorder;
            rightBorder = temp;
        }
        int startBorder = leftBorder % 2 != 0 ? leftBorder : leftBorder + 1;
        int sum = 0;
        for (int i = startBorder; i <= rightBorder; i += 2) {
            sum += i;
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sum = 0;
        for (int element : arrayList) {
            sum += element * 3 + 2;
        }
        return sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int element : arrayList) {
            if (element % 2 != 0) {
                result.add(element * 3 + 2);
            } else {
                result.add(element);
            }
        }
        return result;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        int sum = 0;
        for (int element : arrayList) {
            if (element % 2 != 0) {
                sum += element * 3 + 5;
            }
        }
        return sum;
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        List<Integer> evens = new ArrayList<>();
        for (int element : arrayList) {
            if (element % 2 == 0) {
                evens.add(element);
            }
        }
        Collections.sort(evens);
        float middenIndex = (float) evens.size() / 2;
        int middenLeft = evens.get((int) Math.ceil(middenIndex) - 1);
        int middenRight = evens.get((int) Math.floor(middenIndex));
        return (double) (middenLeft + middenRight) / 2;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        List<Integer> evens = new ArrayList<>();
        for (int element : arrayList) {
            if (element % 2 == 0) {
                evens.add(element);
            }
        }
        int sumOfEvens = 0;
        for (int element : evens) {
            sumOfEvens += element;
        }
        return (double) sumOfEvens / evens.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElement) {
        List<Integer> evens = new ArrayList<>();
        for (int element : arrayList) {
            if (element % 2 == 0) {
                evens.add(element);
            }
        }
        return evens.contains(specialElement);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> evens = new ArrayList<>();
        for (int element : arrayList) {
            if (element % 2 == 0) {
                evens.add(element);
            }
        }
        HashSet<Integer> evensSet = new HashSet<Integer>(evens);
        return new ArrayList<Integer>(evensSet);
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();
        for (int element : arrayList) {
            if (element % 2 == 0) {
                evens.add(element);
            } else {
                odds.add(element);
            }
        }

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

        List<Integer> result = new ArrayList<>();
        Collections.sort(evens);
        Collections.sort(odds, descendingSort);
        result.addAll(evens);
        result.addAll(odds);
        return result;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            result.add((arrayList.get(i) + arrayList.get(i + 1)) * 3);
        }
        return result;
    }
}
