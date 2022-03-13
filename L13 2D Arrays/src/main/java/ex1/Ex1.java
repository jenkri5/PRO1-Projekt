package ex1;

public class Ex1 {

    public static void main(String[] args) {

        int[][] numbers = {
                {0,4,3,9,6},
                {1,3,5,2,2},
                {3,3,1,0,1},
                {0,0,9,7,1}
        };

        print(numbers);
        System.out.println(getValueAt(numbers, 2, 0));
        setValueAt(numbers,0,3, 1);
        print(numbers);
        System.out.println(sumRow(numbers, 0));
        System.out.println(sumCol(numbers, 2));
        System.out.println(sum(numbers));

    }

    public static void print(int[][] numbers) {
        for (int[] row : numbers) {
            for (int number : row) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public static int getValueAt(int[][] numbers, int row, int col) {
        return numbers[row][col];
    }

    public static void setValueAt(int[][] numbers, int row, int col, int value) {
        numbers[row][col] = value;
    }

    public static int sumRow(int[][] numbers, int row) {
        int sum = 0;
        for(int col = 0; col < numbers[row].length; col++)
            sum += numbers[row][col];
        return sum;
    }

    public static int sumCol(int[][] numbers, int col) {
        int sum = 0;
        for (int[] row : numbers)
            sum += row[col];
        return sum;
    }

    public static int sum(int[][] numbers) {
        int sum = 0;
        for(int[] row : numbers)
            for (int i : row)
                sum += i;
        return sum;
    }
}
