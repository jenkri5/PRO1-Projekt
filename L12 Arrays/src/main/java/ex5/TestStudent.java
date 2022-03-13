package ex5;

public class TestStudent {

    public static void main(String[] args) {
        Student s1 = new Student("Hanne");
        Student s2 = new Student("Margrethe");

        //System.out.println(s1.getName());
        //System.out.println(s2.getName());

        s1.addGrade(5);
        s1.addGrade(10);
        s1.addGrade(1);
        System.out.println(s1.maxGrade());
        System.out.println(s1.minGrade());
        System.out.println(s1.gradeAverage());

        for (int i : s1.getActualGrades()) {
            System.out.print(i + ", ");
        }

    }
}
