package Lesson3;

public class Constructor {
    private String firstName;
    private  String lastName;

    public Constructor() {
        this("john","doe"); //생성자에서 다른 생성자를 부를 때에만 this()가 있다.
    }
    public Constructor(String fname) {
        this(fname, "doe");
    }
    public Constructor(String fname, String lname) {
        firstName = fname;
        lastName = lname;
    }
    public String getName() {
        return firstName + " " + lastName;
    }
}
