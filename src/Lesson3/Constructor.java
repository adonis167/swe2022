package Lesson3;

import java.util.ArrayList;

public class Constructor {
    final String firstName;
    private final String lastName;
    private String seperator;
    private ArrayList<String> friends;

    //초기화 블록
    {
        seperator = " ";
        friends = new ArrayList<>();
        friends.add("mike");
        friends.add("jane");
    }

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
        int a = this.plus(3, 5);
        int b = plus(6, 7);
        int c = Constructor.plus(6, 7);

        return firstName + seperator + lastName;
    }
    public String getFriend(int index) {
        return friends.get(index);
    }
    static public int plus(int a, int b) {
        return a + b;
    }
}
