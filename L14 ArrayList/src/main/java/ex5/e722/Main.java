package ex5.e722;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type a sequence of captions and values: ");
        String s = scanner.nextLine();
        String[] stringArr = s.split(" ");

        for (int i = 0; i < stringArr.length; i++) {
            if (i%2 == 0)
                names.add(stringArr[i]);
            else {
                input.add(Integer.parseInt(stringArr[i]));
                output.add(0);
            }
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

        for(int i = 0; i < output.size(); i++) {
            System.out.printf("%10s: ", names.get(i));
            for(int j = output.get(i); j > 0; j--)
                System.out.print("*");
            System.out.println();
        }

        scanner.close();

    }

}
