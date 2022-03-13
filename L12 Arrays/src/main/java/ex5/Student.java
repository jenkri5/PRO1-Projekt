package ex5;

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

    public void addGrade(int grade) {
        if(gradeCount<MAX_GRADE_COUNT) {
            grades[gradeCount] = grade;
            gradeCount++;
        }
    }

    public double gradeAverage() {
        int sum = 0;
        for(int i : grades) {
            sum += i;
        }
        return (double) sum / gradeCount;
    }

    public int maxGrade() {
        int res = 0;
        if(gradeCount>=1) {
            for(int i : grades) {
                res = Math.max(res, i);
            }
        }
        return res;
    }

    public int minGrade() {
        int res = maxGrade();
        if(gradeCount>=1) {
            for(int i = 0; i<gradeCount; i++) {
                res = Math.min(res, grades[i]);
            }
        }
        return res;
    }

    public int[] getActualGrades() {
        int[] actualGrades = new int[gradeCount];
        System.arraycopy(grades, 0, actualGrades, 0, gradeCount);
        return actualGrades;
    }
}
