package ex3;

import org.apache.commons.lang3.RandomUtils;

public class Main {

    public static void main(String[] args) {

        Sequence s1 = new Sequence(5);
        Sequence s2 = new Sequence(5);

        System.out.print("Sequence 1: ");
        s1.print();
        System.out.print("Sequence 2: ");
        s2.print();
        System.out.println("Sequence 1 equals Sequence 2: "+s1.equals(s2));
        s1.set(4, 1);
        System.out.print("Set value of 1 to Sequence 1 at pos 4: ");
        s1.print();
        System.out.println("Sequence 1 equals Sequence 2: "+s1.equals(s2));
        System.out.println("Sequence 1 and 2 have the same values: "+s1.sameValues(s2));
        s2.set(1, 1);
        s2.set(2, 1);
        System.out.print("Set value of 1 to Sequence 2 at pos 1 & 2: ");
        s2.print();
        System.out.println("Sequence 1 and 2 have the same values: "+s1.sameValues(s2));
        System.out.println("Sequence 1 is a permutation of Sequence 2: "+s1.isPermutationOf(s2));
        s1.set(0, 1);
        System.out.print("Add 1 to Sequence 1 at pos 0: ");
        s1.print();
        System.out.println("Sequence 1 is a permutation of Sequence 2: "+s1.isPermutationOf(s2));

        Sequence s3 = makeSequence(20, 0, 100);
        Sequence s4 = makeSequence(10, 0, 100);

        System.out.print("Sequence 3: ");
        s3.print();
        System.out.print("Sequence 4: ");
        s4.print();
        System.out.print("Sum of Sequence 3 and 4: ");
        s3.sum(s4).print();
        s3.sort();
        s4.sort();
        System.out.print("Sequence 3 sorted: ");
        s3.print();
        System.out.print("Sequence 4 sorted: ");
        s4.print();

    }

    public static Sequence makeSequence(int size, int lowerLimit, int upperLimit) {
        Sequence sequence = new Sequence(size);
        for(int i = 0; i < size; i++) {
            sequence.set(i, RandomUtils.nextInt(lowerLimit,upperLimit));
        }
        return sequence;
    }
}
