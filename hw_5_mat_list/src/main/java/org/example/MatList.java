package org.example;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MatList<N extends Number> {

    private List<N> numbers;

    public MatList() {
        this.numbers = new ArrayList<>();
    }

    @SafeVarargs
    public MatList(N[]... numbers) {
        this();
        for (N[] arr : numbers) {
            add(arr);
        }
    }

    @SafeVarargs
    public MatList(MatList<N>... numbers) {
        this();
        for (MatList<N> matList : numbers) {
            add(matList.toArray());
        }
    }

    public void add(N n) {
        numbers.add(n);
    }

    @SafeVarargs
    public final void add(N... n) {
        for (N num : n) {
            numbers.add(num);
        }
    }



    @SafeVarargs
    public final void join(MatList<N>... ml) {
        MatList<N> joinedList = new MatList<>(ml);
        add(joinedList.toArray());
    }

    @SafeVarargs
    public final void intersection(MatList<N>... ml) {
        if (ml.length > 0) {
            List<N> commonNumbers = new ArrayList<>(ml[0].numbers);
            for (int i = 1; i < ml.length; i++) {
                commonNumbers.retainAll(ml[i].numbers);
            }
            numbers = commonNumbers;
        }
    }

    public void sortDesc() {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = 0; j < numbers.size() - i - 1; j++) {
                if (numbers.get(j).doubleValue() < numbers.get(j + 1).doubleValue()) {
                    N temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        if (firstIndex >= 0 && lastIndex < numbers.size() && firstIndex <= lastIndex) {
            for (int i = firstIndex; i < lastIndex; i++) {
                for (int j = firstIndex; j < lastIndex; j++) {
                    if (numbers.get(j).doubleValue() < numbers.get(j + 1).doubleValue()) {
                        N temp = numbers.get(j);
                        numbers.set(j, numbers.get(j + 1));
                        numbers.set(j + 1, temp);
                    }
                }
            }
        }
    }

    public void sortDesc(N value) {
        int index = numbers.indexOf(value);
        if (index != -1) {
            sortDesc(index, numbers.size() - 1);
        }
    }

    public void sortAsc() {
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = 0; j < numbers.size() - i - 1; j++) {
                if (numbers.get(j).doubleValue() > numbers.get(j + 1).doubleValue()) {
                    N temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        if (firstIndex >= 0 && lastIndex < numbers.size() && firstIndex <= lastIndex) {
            for (int i = firstIndex; i < lastIndex; i++) {
                for (int j = firstIndex; j < lastIndex; j++) {
                    if (numbers.get(j).doubleValue() > numbers.get(j + 1).doubleValue()) {
                        N temp = numbers.get(j);
                        numbers.set(j, numbers.get(j + 1));
                        numbers.set(j + 1, temp);
                    }
                }
            }
        }
    }

    public void sortAsc(N value) {
        int index = numbers.indexOf(value);
        if (index != -1) {
            sortAsc(index, numbers.size() - 1);
        }
    }

    public Number get(int index) {
        if (index >= 0 && index < numbers.size()) {
            return numbers.get(index);
        }
        return null;
    }

    public Number getMax() {
        if (numbers.isEmpty()) {
            System.out.println("MatList is empty");
        }
        N max = numbers.get(0);
        for (N number : numbers) {
            if (number.doubleValue() > max.doubleValue()) {
                max = number;
            }
        }
        return max;
    }

    public Number getMin() {
        if (numbers.isEmpty()) {
            System.out.println("MatList is empty");
        }
        N min = numbers.get(0);
        for (N number : numbers) {
            if (number.doubleValue() < min.doubleValue()) {
                min = number;
            }
        }
        return min;
    }

    public Number getAverage() {
        if (numbers.isEmpty()) {
            System.out.println("MatList is empty");
        }
        double sum = 0.0;
        for (N number : numbers) {
            sum += number.doubleValue();
        }
        return sum / numbers.size();
    }

    public Number getMedian() {
        if (numbers.isEmpty()) {
            System.out.println("MatList is empty");
        }
        List<N> sortedList = new ArrayList<>(numbers);
        sortedList.sort(Comparator.comparingDouble(Number::doubleValue));
        int middle = sortedList.size() / 2;
        if (sortedList.size() % 2 == 0) {
            N first = sortedList.get(middle - 1);
            N second = sortedList.get(middle);
            return (first.doubleValue() + second.doubleValue()) / 2;
        } else {
            return sortedList.get(middle).doubleValue();
        }
    }

    public N[] toArray() {
        return numbers.toArray((N[]) new Number[0]);
    }

    public Number[] toArray(int firstIndex, int lastIndex) {
        if (firstIndex < 0 || lastIndex >= numbers.size() || firstIndex > lastIndex) {
            System.out.println("Invalid indices");
        }
        List<N> subList = numbers.subList(firstIndex, lastIndex + 1);
        Number[] result = new Number[subList.size()];
        for (int i = 0; i < subList.size(); i++) {
            result[i] = subList.get(i);
        }
        return result;
    }

    public MatList<N> cut(int firstIndex, int lastIndex) {
        if (firstIndex < 0 || lastIndex >= numbers.size() || firstIndex > lastIndex) {
            System.out.println("Invalid indices");
        }
        List<N> subList = numbers.subList(firstIndex, lastIndex + 1);
        MatList<N> result = new MatList<>();
        result.add(subList.toArray((N[]) new Number[0]));
        numbers = subList;
        return result;
    }

    public void clear() {
        numbers.clear();
    }

    public void clear(N[] values) {
        for (N value : values) {
            numbers.removeIf(element -> element.equals(value));
        }
    }
}
