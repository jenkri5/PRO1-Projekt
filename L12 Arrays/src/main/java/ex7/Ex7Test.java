package ex7;

import java.util.Arrays;
import org.apache.commons.lang3.RandomUtils;

public class Ex7Test {

    public static void main(String[] args) {

        int[] intArray = new int[RandomUtils.nextInt(5, 11)];
        for(int i = 0; i < intArray.length; i++) {
            if(RandomUtils.nextBoolean())
                intArray[i] = RandomUtils.nextInt(0,500);
            else
                intArray[i] = RandomUtils.nextInt(0,500)*-1;
        }

        System.out.println(isAscending(intArray));

        System.out.print("Random int array: ");
        printArray(intArray);
        switchFirstAndLast(intArray);
        System.out.print("Switch first and last number: ");
        printArray(intArray);
        System.out.println("Second highest value: "+getSecondHighest(intArray));
        System.out.println("Is ascending: "+isAscending(intArray));
        Arrays.sort(intArray, 0, intArray.length);
        System.out.print("Sort array: ");
        printArray(intArray);
        System.out.println("Is ascending: "+isAscending(intArray));
        shiftByOne(intArray);
        System.out.print("Shift by one: ");
        printArray(intArray);
        shiftByN(intArray, 4);
        System.out.print("Shift by n=4: ");
        printArray(intArray);
        System.out.println("Has doublets: "+hasDoublets(intArray));
        replaceEvenWithZero(intArray);
        System.out.print("Replace even numbers with zero: ");
        printArray(intArray);
        System.out.println("Has doublets: "+hasDoublets(intArray));

    }

    public static void printArray(int[] intArray) {
        for(int i : intArray) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void switchFirstAndLast(int[] intArray) {
        int temp = intArray[0];
        intArray[0] = intArray[intArray.length-1];
        intArray[intArray.length-1] = temp;
    }

    public static void replaceEvenWithZero(int[] intArray) {
        for(int i = 0; i<intArray.length; i++) {
            if(intArray[i]%2==0) {
                intArray[i] = 0;
            }
        }
    }

    public static int getSecondHighest(int[] intArray) {
        int[] temp = new int[intArray.length];
        System.arraycopy(intArray, 0, temp, 0, intArray.length);
        Arrays.sort(temp);
        int i = 2;
        while(temp[temp.length-1] == temp[temp.length-i] && i < temp.length) {
            i++;
        }
        return temp[temp.length-i];
    }

    public static boolean isAscending(int[] intArray) {
        for(int i = 1; i<intArray.length; i++) {
            if(intArray[i]<intArray[i-1]) {
                return false;
            }
        }
        return true;
    }

    public static void shiftByOne(int[] intArray) {
        int temp = intArray[intArray.length-1];
        System.arraycopy(intArray, 0, intArray, 1, intArray.length - 1);
        intArray[0] = temp;
    }

    public static void shiftByN(int[] intArray, int n) {
        for(int i = 0; i < n; i++) {
            shiftByOne(intArray);
        }
    }

    public static boolean hasDoublets(int[] intArray) {
        for(int i = 0; i<intArray.length; i++) {
            for(int j = i+1; j<intArray.length; j++) {
                if(intArray[i] == intArray[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}