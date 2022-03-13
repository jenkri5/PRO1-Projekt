package ex3;

public class Player {

    private final String name;
    private int age, score;

    public Player(String name, int age) {
        this.name = name;
        this.age = age;
        score = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
    }


}
