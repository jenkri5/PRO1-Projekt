package ex6;

public class TestChild {

    public static void main(String[] args) {
        Child b1 = new Child("Emma");
        Child b2 = new Child("Oliver");

        System.out.println(b1.getName());
        System.out.println(b2.getName());


        b1.addWeight(4.2);
        b1.addWeight(9.3);
        b1.addWeight(12.4);
        b1.addWeight(17.5);
        b1.addWeight(23.2);
        b1.addWeight(25.3);
        b1.addWeight(28.6);
        b1.addWeight(30.4);
        b1.addWeight(33.9);
        b1.addWeight(35.1);
        b1.addWeight(37.3);

        System.out.printf("%s's weight at age 5: %.1fkg\n",b1.getName(),b1.getWeight(5));
        System.out.printf("Her max yearly weight gain was: %.2fkg",b1.maxYearlyWeightGain());
    }

}
