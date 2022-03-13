package ex4student;

public class Stars {
    public void starExA(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {
            System.out.printf("%2d: ", row);
            int starCount = rowCount - row + 1;
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }
            for (int i = 1; i <= dashCount; i++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void starExB(int rowCount) {
        for(int row = 1; row <= rowCount; row++) {
            System.out.printf("%2d: ", row);
            int dashCount = rowCount - row;
            int starCount = rowCount - dashCount;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void starExC(int rowCount) {
        for (int row = 1; row <= rowCount; row++) {
            System.out.printf("%2d: ", row);
            int starCount = rowCount - row + 1;
            int dashCount = rowCount - starCount;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void starExD(int rowCount) {
        int col;
        if(rowCount%2 == 0)
            col = rowCount-1;
        else
            col = rowCount;
        int starCount = 0;
        int dashCount;
        for (int row = 1; row <= rowCount; row++) {
            System.out.printf("%2d: ", row);
            if(row <= rowCount/2)
                starCount = row+row-1;
            else if (row == rowCount/2+1 && rowCount%2 == 1)
                starCount = row+row-1;
            else if (row == rowCount/2+1 && rowCount%2 == 0)
                starCount = row-1+row-2;
            else starCount = starCount - 2;
            dashCount = (col - starCount)/2;
            for (int i = 1; i <= dashCount; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= starCount; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
