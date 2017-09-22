package Lesson3;

public class ClassBase1 {
    static public void main(String args[]) {
        Constructor c = new Constructor();
        System.out.println(c.getName());
        Constructor c1 = new Constructor("a");
        System.out.println(c1.getName());
        Constructor c2 = new Constructor("a","b");
        System.out.println(c2.getName());
    }
}
