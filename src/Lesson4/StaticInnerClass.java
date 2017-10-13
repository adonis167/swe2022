package Lesson4;

import Lesson4.sample.Imported;

public class StaticInnerClass {
    private static class Class1{
        static class Class1Class1{}
        Class1(){
            System.out.println(Imported.getText());
        }
    }
    static class Class2{
        static class Class2Class1{}
    }
    static public void main(String[] arg){
        Lesson4.StaticInnerClass.Class1.Class1Class1 c = new StaticInnerClass.Class1.Class1Class1();
        System.out.println(Imported.getText());

    }
}
