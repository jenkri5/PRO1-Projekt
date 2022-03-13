package ex4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex4Test {

    public static void main(String[] args) {
        ArrayList<Integer> integerArrayList = new ArrayList<>(List.of(1, 4, 9, 16, 25));
        System.out.println(integerArrayList);
        switchFirstAndLast(integerArrayList);
        System.out.println(integerArrayList);
        setEvenToZero(integerArrayList);
        System.out.println(integerArrayList);
        System.out.println("Second highest value: "+getSecondHighest(integerArrayList));
        System.out.println("Is ascending: "+isAscending(integerArrayList));
        shiftRight(integerArrayList);
        System.out.println(integerArrayList);
        System.out.println("Has doublets: "+hasDoublets(integerArrayList));
    }

    private static void switchFirstAndLast(ArrayList<Integer> integerArrayList) {
        Collections.swap(integerArrayList, 0, integerArrayList.size()-1);
    }

    private static void setEvenToZero(ArrayList<Integer> integerArrayList) {
        for(Integer i : integerArrayList) {
            if(i%2 == 0)
                integerArrayList.set(integerArrayList.lastIndexOf(i), 0);
        }
    }

    private static int getSecondHighest(ArrayList<Integer> integerArrayList) {
        ArrayList<Integer> temp = (ArrayList<Integer>) integerArrayList.clone();
        Collections.sort(temp);
        int i = 2;
        while(temp.get(temp.size()-1).equals(temp.get(temp.size()-i)) && i < temp.size()) {
            i++;
        }
        return temp.get(temp.size()-i);

    }

    private static boolean isAscending (ArrayList<Integer> integerArrayList) {
        ArrayList<Integer> temp = (ArrayList<Integer>) integerArrayList.clone();
        Collections.sort(temp);
        return integerArrayList.equals(temp);
    }

    private static void shiftRight(ArrayList<Integer> integerArrayList) {
        ArrayList<Integer> temp = new ArrayList<>(integerArrayList.subList(0, integerArrayList.size()-1));
        temp.add(0,integerArrayList.get(integerArrayList.size()-1));
        Collections.copy(integerArrayList, temp);
    }

    private static boolean hasDoublets(ArrayList<Integer> integerArrayList) {
        for(int i = 0; i < integerArrayList.size(); i++) {
            for(int j = i+1; j < integerArrayList.size(); j++) {
                if(integerArrayList.get(i).equals(integerArrayList.get(j)))
                    return true;
            }
        }
        return false;
    }
}
