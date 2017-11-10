package Lesson8;

public class CloneMain {

    public static void main(String args[]) {
        Base b1 = new Base(10);
        Owner o1 = new Owner(10, b1);

        Owner o2 = null;

        try {
            o2  = o1.clone();
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

        Base b2 = o1.getBase();
        b2.baseValue = 20;
        System.out.println(o2.getBase().baseValue);
    }
}
