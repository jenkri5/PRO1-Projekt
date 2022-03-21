package demo4listview;

public class Person
{
    private String firstName;
    private String lastName;
    private String email;

    public Person(String firstName, String lastName, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return this.email;
    }

    @Override
    public String toString()
    {
        return firstName + " " + lastName + " (" + email + ")";
    }

}
