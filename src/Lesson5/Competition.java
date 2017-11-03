package Lesson5;

public class Competition {
    public static String compare(Comparable a, Comparable b) {
        if(a.compareTo(b) == -1) return "a is a winner";
        return "b is a winner";
    }
}
