package ex2;

public class Child {

    private int age;
    private final boolean male;

    public Child(int age, boolean male) {
        this.age = age;
        this.male = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public String institution() {
        if (age == 0) {
            return "Home";
        } else if (age>=1 && age<=2) {
            return "Nursery";
        } else if (age>=3 && age<=5) {
            return "Kindergarten";
        } else if (age>=6 && age<=16) {
            return "School";
        } else {
            return "Out of school";
        }
    }

    public String gender() {
        if (male == true) {
            return "Boy";
        } else {
            return "Girl";
        }
    }

    public String team() {
        if(male == true) {
            if (age < 8) {
                return "Young boys";
            } else {
                return "Cool boys";
            }
        } else {
            if (age < 8) {
                return "Tumbling girls";
            } else {
                return "Springy girls";
            }
        }
    }
}
