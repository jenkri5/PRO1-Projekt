package ex3;

import java.util.Arrays;

public class Sequence {

    private final int[] values;

    public Sequence(int size) {
        values = new int[size];
    }

    public void print() {
        System.out.println(Arrays.toString(values));
    }

    public void set(int i, int n) {
        values[i] = n;
    }

    public int get(int i) {
        return values[i];
    }

    public int size() {
        return values.length;
    }

    public boolean equals(Sequence other) {
        return Arrays.equals(values, other.values);
    }

    public boolean sameValues(Sequence other) {
        int[] tempSequence = Arrays.stream(Arrays.copyOf(values, size())).sorted().distinct().toArray();
        int[] tempOther = Arrays.stream(Arrays.copyOf(other.values, other.size())).sorted().distinct().toArray();
        return Arrays.equals(tempSequence,tempOther);
    }

    public boolean isPermutationOf(Sequence other) {
        int[] tempSequence = Arrays.stream(Arrays.copyOf(values, size())).sorted().toArray();
        int[] tempOther = Arrays.stream(Arrays.copyOf(other.values, other.size())).sorted().toArray();
        return Arrays.equals(tempSequence,tempOther);
    }

    public Sequence sum(Sequence other) {
        Sequence sum = new Sequence(Math.max(size(), other.size()));
        for(int i = 0; i < size(); i++)
            sum.set(i, sum.get(i)+values[i]);
        for(int i = 0; i < other.size(); i++)
            sum.set(i,sum.get(i)+other.values[i]);
        return sum;
    }

    public void sort() {
        Arrays.sort(values);
    }
}
