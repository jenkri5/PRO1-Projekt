package ex4;

public class Main {

    public static void main(String[] args) {

        int[][] solution = {
                {9,6,3,1,7,4,2,5,8},
                {1,7,8,3,2,5,6,4,9},
                {2,5,4,6,8,9,7,3,1},
                {8,2,1,4,3,7,5,9,6},
                {4,9,6,8,5,2,3,1,7},
                {7,3,5,9,6,1,8,2,4},
                {5,8,9,7,1,3,4,6,2},
                {3,1,7,2,4,6,9,8,5},
                {6,4,2,5,9,8,1,7,3}
        };

        int[][] solution2 = {
                {9,5,3,1,7,4,2,5,8},
                {1,7,8,3,2,5,6,4,9},
                {2,5,4,6,2,9,7,3,1},
                {8,2,1,4,3,7,5,9,6},
                {4,9,6,8,5,2,3,1,7},
                {7,3,5,9,6,1,8,2,4},
                {5,8,9,7,1,3,4,6,2},
                {3,1,3,2,4,6,9,8,5},
                {6,4,2,5,9,8,1,7,9}
        };

        SudokuSolutionChecker sudoku = new SudokuSolutionChecker(solution);
        SudokuSolutionChecker sudoku2 = new SudokuSolutionChecker(solution2);


        System.out.println("Solution 1:");
        System.out.print("Rows: ");
        System.out.print(sudoku.checkRow(0)+" ");
        System.out.print(sudoku.checkRow(1)+" ");
        System.out.print(sudoku.checkRow(2)+" ");
        System.out.print(sudoku.checkRow(3)+" ");
        System.out.print(sudoku.checkRow(4)+" ");
        System.out.print(sudoku.checkRow(5)+" ");
        System.out.print(sudoku.checkRow(6)+" ");
        System.out.print(sudoku.checkRow(7)+" ");
        System.out.println(sudoku.checkRow(8));
        System.out.println("All rows: "+sudoku.checkRows());
        System.out.print("Cols: ");
        System.out.print(sudoku.checkCol(0)+" ");
        System.out.print(sudoku.checkCol(1)+" ");
        System.out.print(sudoku.checkCol(2)+" ");
        System.out.print(sudoku.checkCol(3)+" ");
        System.out.print(sudoku.checkCol(4)+" ");
        System.out.print(sudoku.checkCol(5)+" ");
        System.out.print(sudoku.checkCol(6)+" ");
        System.out.print(sudoku.checkCol(7)+" ");
        System.out.println(sudoku.checkCol(8));
        System.out.println("All cols: "+sudoku.checkCols());
        System.out.print("Box at [0,0]: "+sudoku.checkBox(0, 0)+", ");
        System.out.print("Box at [0,3]: "+sudoku.checkBox(0, 3)+", ");
        System.out.println("Box at [0,6]: "+sudoku.checkBox(0, 6));
        System.out.print("Box at [3,0]: "+sudoku.checkBox(3, 0)+", ");
        System.out.print("Box at [3,3]: "+sudoku.checkBox(3, 3)+", ");
        System.out.println("Box at [3,6]: "+sudoku.checkBox(3, 6));
        System.out.print("Box at [6,0]: "+sudoku.checkBox(6, 0)+", ");
        System.out.print("Box at [6,3]: "+sudoku.checkBox(6, 3)+", ");
        System.out.println("Box at [6,6]: "+sudoku.checkBox(6, 6));
        System.out.println("All boxes: "+sudoku.checkBoxes());
        System.out.println("Solution is: "+sudoku.isSolved());

        System.out.println();

        System.out.println("Solution 2:");
        System.out.print("Rows: ");
        System.out.print(sudoku2.checkRow(0)+" ");
        System.out.print(sudoku2.checkRow(1)+" ");
        System.out.print(sudoku2.checkRow(2)+" ");
        System.out.print(sudoku2.checkRow(3)+" ");
        System.out.print(sudoku2.checkRow(4)+" ");
        System.out.print(sudoku2.checkRow(5)+" ");
        System.out.print(sudoku2.checkRow(6)+" ");
        System.out.print(sudoku2.checkRow(7)+" ");
        System.out.println(sudoku2.checkRow(8));
        System.out.println("All rows: "+sudoku2.checkRows());
        System.out.print("Cols: ");
        System.out.print(sudoku2.checkCol(0)+" ");
        System.out.print(sudoku2.checkCol(1)+" ");
        System.out.print(sudoku2.checkCol(2)+" ");
        System.out.print(sudoku2.checkCol(3)+" ");
        System.out.print(sudoku2.checkCol(4)+" ");
        System.out.print(sudoku2.checkCol(5)+" ");
        System.out.print(sudoku2.checkCol(6)+" ");
        System.out.print(sudoku2.checkCol(7)+" ");
        System.out.println(sudoku2.checkCol(8));
        System.out.println("All cols: "+sudoku2.checkCols());
        System.out.print("Box at [0,0]: "+sudoku2.checkBox(0, 0)+", ");
        System.out.print("Box at [0,3]: "+sudoku2.checkBox(0, 3)+", ");
        System.out.println("Box at [0,6]: "+sudoku2.checkBox(0, 6));
        System.out.print("Box at [3,0]: "+sudoku2.checkBox(3, 0)+", ");
        System.out.print("Box at [3,3]: "+sudoku2.checkBox(3, 3)+", ");
        System.out.println("Box at [3,6]: "+sudoku2.checkBox(3, 6));
        System.out.print("Box at [6,0]: "+sudoku2.checkBox(6, 0)+", ");
        System.out.print("Box at [6,3]: "+sudoku2.checkBox(6, 3)+", ");
        System.out.println("Box at [6,6]: "+sudoku2.checkBox(6, 6));
        System.out.println("All boxes: "+sudoku2.checkBoxes());
        System.out.println("Solution is: "+sudoku2.isSolved());
        System.out.println();

    }
}
