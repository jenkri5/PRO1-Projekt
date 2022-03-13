package ex2ex3student;

public class Person {
    private final String name;
    private final int dayOfBirth; // 1..31
    private final int monthOfBirth; // 1..12
    private final int yearOfBirth; // 1900..2010

    public Person(String name, int yearOfBirth, int monthOfBirth, int dayOfBirth) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
    }

    public void printPerson() {
        System.out.println(name + ", born " + yearOfBirth + "-" + monthOfBirth + "-" + dayOfBirth);
    }

    public int calcAge(int year, int month, int day) {
        return (monthOfBirth == month)? (dayOfBirth > day)? year-yearOfBirth-1 : year-yearOfBirth : (monthOfBirth > month)? year - yearOfBirth - 1 : year - yearOfBirth;
    }

    public boolean isLeapYear(int year) {
        return (year%4 == 0)? (year%100 == 0)? (year%400 == 0)? true : false : true : false;
    }
}
