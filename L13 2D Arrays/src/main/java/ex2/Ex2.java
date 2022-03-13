package ex2;

import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;

public class Ex2 {

    enum PossibleAnswers {
        A,
        B,
        C,
        D
    }

    public static void main(String[] args) {
        char[][] answers = new char[8][10];
        char[] correctAnswers = {'A', 'B', 'C', 'D', 'C', 'B', 'A', 'B', 'C', 'D'};

        System.out.printf("Correct answers:\t%s\n",Arrays.toString(correctAnswers));

        for(int student = 0; student < answers.length; student++) {
            for(int question = 0; question < answers[student].length; question ++) {
                answers[student][question] = PossibleAnswers.values()[RandomUtils.nextInt(0, PossibleAnswers.values().length)].toString().charAt(0);
            }
            System.out.printf("Student %-3d:\t\t%s\n", student+1, Arrays.toString(answers[student]));
        }

        System.out.println();

        correctAnswersStudents(answers, correctAnswers);

        System.out.println();

        correctAnswersQuestion(answers, correctAnswers);


    }

    public static void correctAnswersStudents(char[][] answers, char[] correctAnswers) {

        for(int student = 0; student < answers.length; student++) {
            int correct = 0;
            char[] nAnswers = new char[answers[student].length];
            for(int question = 0; question < answers[student].length; question++) {
                if(answers[student][question] == correctAnswers[question]) {
                    nAnswers[question] = correctAnswers[question];
                    correct++;
                }
            }
            System.out.println("Student "+(student+1)+" scored: "+correct+"/"+answers[student].length);
        }

    }

    public static void correctAnswersQuestion(char[][] answers, char[] correctAnswers) {
        int studentIndex = 0;
        for(int question = 0; question < answers[studentIndex].length; question++) {
            int correct = 0;
            char[] nAnswers = new char[answers[studentIndex].length];
            for(int student = 0; student < answers.length; student++) {
                if(answers[student][question] == correctAnswers[question]) {
                    nAnswers[question] = correctAnswers[question];
                    correct++;
                }
                studentIndex++;
            }
            studentIndex=0;
            System.out.println("Question "+(question+1)+" was answered correctly: "+correct+"/"+answers.length+" times");
        }
    }

}
