package ex2;

public class Variables {

    public static void main(String[] args) {
        int i1;
        char ch1, ch2;

        ch1 = 'A';
        System.out.println("ch1: " + ch1);
        ch2 = '3';
        System.out.println("ch2: " + ch2);
        i1 = ch1;
        System.out.println("i1: " + i1);
        i1 = 66;
        System.out.println("i1: " + i1);
        ch2 = (char) i1;
        System.out.println("ch2: " + ch2);
    }
}
