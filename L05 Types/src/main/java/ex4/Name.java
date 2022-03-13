package ex4;

public class Name {

    private String firstName, middleName, lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.middleName = null;
        this.lastName = lastName;
    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return firstName; }

    public void setMiddleName(String middleName) {this.middleName = middleName; }
    public String getMiddleName() { return middleName; }

    public void setLastName(String lastName) {this.lastName = lastName; }
    public String getLastName() { return lastName; }

    public String getFullName() {
        if (middleName!=null) {
            return firstName + " " + middleName + " " + lastName;
        } else return firstName + " " + lastName;
    }

    public String getUsername() {
        if (middleName!=null) {
            return firstName.substring(0, 2).toUpperCase() + middleName.length() + lastName.substring(lastName.length() - 2);
        } else return firstName.substring(0, 2).toUpperCase() + "0" + lastName.substring(lastName.length() - 2);
    }

    public String getInits() {
        if (middleName!=null) {
            return firstName.substring(0, 1) + middleName.substring(0,1) + lastName.substring(0, 1);
        } else return firstName.substring(0, 1) + lastName.substring(0, 1);
    }

    public String getCryptoInits(int count) {

        char firstChar = firstName.charAt(0);
        int firstInt = (int) firstChar + count;
        firstChar = (char) firstInt;

        char lastChar = lastName.charAt(0);
        int lastInt = (int) lastChar + count;
        lastChar = (char) lastInt;

        if (middleName!=null) {
            char middleChar = middleName.charAt(0);
            int middleInt = (int) middleChar + count;
            middleChar = (char) middleInt;

            return firstChar + Character.toString(middleChar) + lastChar;
        } else {
            return firstChar + Character.toString(lastChar);
        }
    }

}
