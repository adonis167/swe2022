package Lesson1;

public class ControlState {
    static public void main(String args[]) {
        System.out.println("Point1");
        test1: {
            int a = 3;
            if(a>2) break test1;
            System.out.println("Point2");
        }
        System.out.println("Point3");

    }
}
