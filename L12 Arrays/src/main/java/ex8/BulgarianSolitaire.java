package ex8;

import java.util.Arrays;

public class BulgarianSolitaire {

    private final int[] goal = {1,2,3,4,5,6,7,8,9};
    private final int[] piles = new int[45];
    private int currentSize, stepCounter, totalCounter, maxSteps, minSteps, gameCounter;
    private boolean done;

    public BulgarianSolitaire() {
        totalCounter = 0;
        maxSteps = Integer.MIN_VALUE;
        minSteps = Integer.MAX_VALUE;
        gameCounter = 0;
    }

    public void initialize() {

        for(int i = 0; i < currentSize; i++) {
            piles[i] = 0;
        }

        int total = 45;
        currentSize = 0;
        stepCounter = 0;
        done = false;

        for(int i = 0; total > 0; i++) {
            int rn = (int) (Math.random()*(total-1))+1;
            total -= rn;
            piles[i] = rn;
            currentSize++;
        }

        if(currentSize == 9) {
            int[] temp = new int[currentSize];
            System.arraycopy(piles, 0, temp, 0, currentSize);
            Arrays.sort(temp,0,currentSize);
            done = Arrays.equals(temp, goal);
        }

        for(int i = 0; i<currentSize; i++)
            System.out.print(piles[i]+" ");
        System.out.println();
        System.out.println("--------------------");

    }

    public void run() {

        initialize();

        while(!done) {
            int newPile = 0;
            for(int i = 0; i < currentSize; i++) {
                piles[i] = piles[i]-1;
                newPile++;
            }

            piles[currentSize] = newPile;
            currentSize++;

            for(int i = currentSize-1; i >= 0; i--) {
                if(piles[i] == 0) {
                    System.arraycopy(piles, i + 1, piles, i, currentSize - i);
                    currentSize--;
                }
            }

            for(int i = 0; i<currentSize; i++)
                System.out.print(piles[i]+" ");
            System.out.println();

            stepCounter++;

            if(currentSize == 9) {
                int[] temp = new int[currentSize];
                System.arraycopy(piles, 0, temp, 0, currentSize);
                Arrays.sort(temp,0,currentSize);
                done = Arrays.equals(temp, goal);
            }
        }
        totalCounter += stepCounter;
        if(maxSteps < stepCounter)
            maxSteps = stepCounter;
        if(minSteps > stepCounter)
            minSteps = stepCounter;
        gameCounter++;
        System.out.println("--------------------");
        System.out.println("Solution reached in "+ stepCounter +" steps");
    }

    public void printStats() {
        System.out.println("You played "+gameCounter+" games.");
        System.out.println("Best result: "+ minSteps);
        System.out.println("Worst result: "+ maxSteps);
        System.out.println("Average steps: "+totalCounter/gameCounter);
    }

}
