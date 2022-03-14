package ex5.p72;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> sequence = new ArrayList<>();

        for(int j = 0; j < 100; j++) {
            for (int i = 0; i < 20; i++) {
                sequence.add(RandomUtils.nextInt(0, 6) + 1);
            }

            boolean inRun = false;


            for (int i = 0; i < sequence.size() - 1; i++) {
                if (inRun) {
                    if (sequence.get(i) != sequence.get(i - 1)) {
                        System.out.print(")");
                        inRun = false;
                    }
                }
                if (!inRun) {
                    if (sequence.get(i) == sequence.get(i + 1)) {
                        System.out.print("(");
                        inRun = true;
                    }
                }
                System.out.print(sequence.get(i));
            }
            if (inRun)
                System.out.print(")");
            sequence.clear();
            System.out.println();
        }
    }
}
