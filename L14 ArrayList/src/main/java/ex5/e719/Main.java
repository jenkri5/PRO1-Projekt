package ex5.e719;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type a sequence of numbers: ");
        String s = scanner.nextLine();
        String[] numbers = s.split(" ");

        for (String number : numbers) {
            input.add(Integer.parseInt(number));
            output.add(0);
        }

        int indexOfNext = 0;
        int outputVal = 40;
        int lastVal;
        double p;

        for(int i : input)
            if (i > input.get(indexOfNext))
                indexOfNext = input.indexOf(i);

        lastVal = input.get(indexOfNext);

        for (int ignored : input) {
            p = (double) input.get(indexOfNext) / lastVal;
            double temp = p * outputVal;
            outputVal = (int) temp;
            output.set(indexOfNext, outputVal);
            lastVal = input.get(indexOfNext);
            input.set(indexOfNext, 0);
            for(int i : input)
                if (i > input.get(indexOfNext))
                    indexOfNext = input.indexOf(i);
        }

        for(int i : output) {
            for(int j = i; j > 0; j--)
                System.out.print("*");
            System.out.println();
        }
        scanner.close();
    }
}
