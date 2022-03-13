package ex5student;

public class Student {
    private final String name;
    private final int[] grades;// containing the student's grades
    private int gradeCount;// the current number of grades

    private static final int MAX_GRADE_COUNT = 10;// maximum number of grades

    public Student(String name) {
        this.name = name;
        this.grades = new int[Student.MAX_GRADE_COUNT];
        this.gradeCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public int[] getGrades() {
        return this.grades;
    }

    public int getGradeCount() {
        return this.gradeCount;
    }
}
