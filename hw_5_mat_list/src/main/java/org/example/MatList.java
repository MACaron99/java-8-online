package org.example;

public class MatList<N extends Number> {

    private Number[] numbers;
    private int size = 0;

    public MatList() {
        this.numbers = new Number[10];
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
        if (size == numbers.length - 1) {
            Number[] newNumbers = new Number[numbers.length * 2];
            System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
            numbers = newNumbers;
        }
        numbers[size] = n;
        size++;
    }

    @SafeVarargs
    public final void add(N... n) {
        for (N num : n) {
            if (size == numbers.length - 1) {
                Number[] newNumbers = new Number[numbers.length * 2];
                System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
                numbers = newNumbers;
            }
            numbers[size] = num;
            size++;
        }
    }

    public Number[] findAll() {
        return numbers;
    }

    @SafeVarargs
    public final void join(MatList<N>... ml) {
        MatList<N> joinedList = new MatList<>(ml);
        add(joinedList.toArray());
    }

    @SafeVarargs
    public final void intersection(MatList<N>... ml) {
        if (ml.length > 0) {
            int minSize = ml[0].numbers.length;
            for (int i = 1; i < ml.length; i++) {
                if (ml[i].numbers.length < minSize) {
                    minSize = ml[i].numbers.length;
                }
            }
            int newIndex = 0;
            Number[] commonNumbers = new Number[minSize];
            for (int i = 0; i < size; i++) {
                boolean isCommon = false;
                for (int j = 0; j < ml[0].size; j++) {
                    if (numbers[i].equals(ml[0].numbers[j])) {
                        isCommon = true;
                        break;
                    }
                }
                if (isCommon) {
                    commonNumbers[newIndex] = numbers[i];
                    newIndex++;
                }
            }
            numbers = commonNumbers;
            size = newIndex;
        }
    }

    public void sortDesc() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (numbers[j].doubleValue() < numbers[j + 1].doubleValue()) {
                    Number number = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = number;
                }
            }
        }
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        if (firstIndex >= 0 && lastIndex < size && firstIndex <= lastIndex) {
            for (int i = firstIndex; i < lastIndex; i++) {
                for (int j = firstIndex; j < lastIndex; j++) {
                    if (numbers[j].doubleValue() < numbers[j + 1].doubleValue()) {
                        Number number = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = number;
                    }
                }
            }
        } else {
            System.out.println("Invalid index");
        }
    }

    public void sortDesc(N value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (numbers[i].equals(value)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            sortDesc(index, size - 1);
        }
    }

    public void sortAsc() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (numbers[j].doubleValue() > numbers[j + 1].doubleValue()) {
                    Number number = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = number;
                }
            }
        }
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        if (firstIndex >= 0 && lastIndex < size && firstIndex <= lastIndex) {
            for (int i = firstIndex; i < lastIndex; i++) {
                for (int j = firstIndex; j < lastIndex; j++) {
                    if (numbers[j].doubleValue() > numbers[j + 1].doubleValue()) {
                        Number number = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = number;
                    }
                }
            }
        } else {
            System.out.println("Invalid index");
        }
    }

    public void sortAsc(N value) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (numbers[i].equals(value)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            sortAsc(index, size - 1);
        }
    }

    public Number get(int index) {
        if (index >= 0 && index < size) {
            return numbers[index];
        } else {
            System.out.println("Invalid index");
        }
        return null;
    }

    public Number getMax() {
        if (size == 0) {
            System.out.println("MatList is empty");
        } else {
            Number max = numbers[0];
            for (int i = 0; i < size; i++) {
                if (numbers[i].doubleValue() > max.doubleValue()) {
                    max = numbers[i];
                }
            }
            return max;
        }
        return null;
    }

    public Number getMin() {
        if (size == 0) {
            System.out.println("MatList is empty");
        } else {
            Number min = numbers[0];
            for (int i = 0; i < size; i++) {
                if (numbers[i].doubleValue() < min.doubleValue()) {
                    min = numbers[i];
                }
            }
            return min;
        }
        return null;
    }

    public Number getAverage() {
        if (size == 0) {
            System.out.println("MatList is empty");
        } else {
            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                sum += numbers[i].doubleValue();
            }
            return sum / size;
        }
        return null;
    }

    public Number getMedian() {
        if (size == 0) {
            System.out.println("MatList is empty");
        } else {
            sortAsc();
            int median = size / 2;
            if (size % 2 == 0) {
                Number first = numbers[median - 1];
                Number second = numbers[median];
                return (first.doubleValue() + second.doubleValue()) / 2;
            } else {
                return numbers[median].doubleValue();
            }
        }
        return null;
    }

    public N[] toArray() {
        Number[] array = new Number[size];
        for (int i = 0; i < size; i++) {
            array[i] = numbers[i];
        }
        return (N[]) array;
    }

    public N[] toArray(int firstIndex, int lastIndex) {
        if (firstIndex < 0 || lastIndex >= size || firstIndex > lastIndex) {
            System.out.println("Invalid indices");
        } else {
            int resultSize = lastIndex - firstIndex +1;
            Number[] array = new Number[resultSize];
            for (int i = 0; i < resultSize; i++) {
                array[i] = numbers[firstIndex + i];
            }
            return (N[]) array;
        }
        return null;
    }

    public MatList<N> cut(int firstIndex, int lastIndex) {
        N[] array = toArray(firstIndex, lastIndex);
        MatList<N> result = new MatList<>();
        result.add(array);
        numbers = array;
        size = array.length;
        return result;
    }

    public void clear() {
        this.numbers = new Number[10];
        size = 0;
    }

    public void clear(Number[] values) {
        int newIndex = 0;
        Number[] newNumbers = new Number[size];
        for (int i = 0; i < size; i++) {
            boolean truth = true;
            for (Number value : values) {
                if (numbers[i].equals(value)) {
                    truth = false;
                    break;
                }
            }
            if (truth) {
                newNumbers[newIndex] = numbers[i];
                newIndex++;
            }
        }
        numbers = newNumbers;
        size = newIndex;
    }
}
