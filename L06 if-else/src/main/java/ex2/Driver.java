package ex2;

public class Driver {

    public static void main(String[] args) {
        Child c0 = new Child(0, true);
        Child c1 = new Child(1, false);
        Child c2 = new Child(3, true);
        Child c3 = new Child(6, false);
        Child c4 = new Child(12, true);
        Child c5 = new Child(17, false);

        System.out.println("Institution: "+c0.institution()+", Gender: "+c0.gender()+", Team: "+c0.team());
        System.out.println("Institution: "+c1.institution()+", Gender: "+c1.gender()+", Team: "+c1.team());
        System.out.println("Institution: "+c2.institution()+", Gender: "+c2.gender()+", Team: "+c2.team());
        System.out.println("Institution: "+c3.institution()+", Gender: "+c3.gender()+", Team: "+c3.team());
        System.out.println("Institution: "+c4.institution()+", Gender: "+c4.gender()+", Team: "+c4.team());
        System.out.println("Institution: "+c5.institution()+", Gender: "+c5.gender()+", Team: "+c5.team());

    }
}
