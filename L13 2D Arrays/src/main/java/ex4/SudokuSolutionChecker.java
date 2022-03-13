package ex4;

import java.util.Arrays;

public class SudokuSolutionChecker {

    private final int[][] solution;
    private final int[] goal = {1,2,3,4,5,6,7,8,9};

    public SudokuSolutionChecker(int[][] solution) {
        this.solution = solution;
    }

    public boolean isSolved() {
        return checkRows() && checkCols() && checkBoxes();
    }

    public boolean checkRow(int row) {
        int[] temp = new int[solution[row].length];
        System.arraycopy(solution[row], 0, temp, 0, temp.length);
        Arrays.sort(temp);
        return Arrays.equals(temp, goal);
    }

    public boolean checkRows() {
        for(int row = 0; row < solution.length; row++) {
            if(!checkRow(row))
                return false;
        }
        return true;
    }

    public boolean checkCol(int col) {
        int[] temp = new int[solution.length];
        for(int row = 0; row < solution[col].length; row++) {
            temp[row] = solution[row][col];
        }
        Arrays.sort(temp);
        return Arrays.equals(temp, goal);
    }

    public boolean checkCols() {
        for(int col = 0; col < solution.length; col++) {
            if(!checkCol(col))
                return false;
        }
        return true;
    }

    public boolean checkBox(int startRow, int startCol) {
        int[] temp = new int[solution.length];
        int i = 0;
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                temp[row+col+i] = solution[startRow+row][startCol+col];
            }
            i+=2;
        }
        Arrays.sort(temp);
        return Arrays.equals(temp, goal);
    }

    public boolean checkBoxes() {
        for(int startRow = 0; startRow < solution.length; startRow+=3) {
            for(int startCol = 0; startCol < solution.length; startCol+=3) {
                if(!checkBox(startRow, startCol))
                    return false;
            }
        }
        return true;
    }

}
