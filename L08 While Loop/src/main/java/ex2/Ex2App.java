package ex2;

public class Ex2App {

    public static void main(String[] args) {
        int sum = 0;
        int i = 2;
        while(i <= 100) {
            sum = sum + i;
            i = i + 2;
        }
        System.out.println("The sum of all even numbers between 2 and 100 (inclusive): " + sum);
        sum = 0;
        i = 0;
        while(i <= 100) {
            sum = sum + i * i;
            i++;
        }
        System.out.println("The sum of all squares between 1 and 100 (inclusive): " + sum);
        sum = 0;
        i = 0;
        while(i <= 20) {
            sum = sum + (int)Math.pow(2, i);
            System.out.println("Power of 2^" + i + ": " + (int)Math.pow(2, i));
            i++;
        }
        System.out.println("All powers of 2 from 2^0 up to 2^20: " + sum);
    }
}
