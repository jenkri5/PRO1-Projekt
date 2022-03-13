package ex2;

public class Ex2App {

    public static void main(String[] args) {

        System.out.print("All uneven numbers between 1 and 100: ");
        for(int i = 1; i <= 100; i+=2) {
            System.out.print(i + ", ");
        }
        System.out.println();

        System.out.print("All multiples of 3 between 300 and 3: ");
        for(int i = 300; i >= 3; i-=3) {
            System.out.print(i+" ");
        }
    }
}
