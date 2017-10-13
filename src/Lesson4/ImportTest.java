package Lesson4;

import Lesson4.sample.Imported;
import Lesson4.StaticInnerClass.Class2.Class2Class1;
public class ImportTest {
    static public void main(String[] arg){
        System.out.println(Lesson4.sample.Imported.getText());
        System.out.println(Imported.getText());
        StaticInnerClass.Class2 c = new StaticInnerClass.Class2();
        Class2Class1 c2 = new Class2Class1();
    }
}
