package ex3;

public class Person {
    private String name;
    private String title;
    private boolean senior;

    public Person(String name, String title, boolean senior) {
        this.name = name;
        this.title = title;
        this.senior = senior;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public boolean isSenior() {
        return this.senior;
    }

    @Override
    public String toString() {
        if (senior)
            return title + " " + name + " (senior)";
        else
            return title + " " + name;
    }

}
