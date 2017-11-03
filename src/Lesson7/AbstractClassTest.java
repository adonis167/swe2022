package Lesson7;

public class AbstractClassTest {

    static abstract class Person {
        private String name;

        public Person(){this.name="";}
        public Person(String name) {this.name = name;}
        public final String getName() {return name;}

        public abstract int getId();
    }

    static class Student extends Person {
        private int id;

        public Student(String name, int id) {
            //super();
            this.id = id;
        }

        @Override
        public int getId() {
            return 0;
        }
    }

    public static void main(String args[]) {
        Person p = new Person("Jiho") {
            @Override
            public int getId() {
                return 0;
            }
        };

    }
}
