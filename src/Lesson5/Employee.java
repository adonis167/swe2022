package Lesson5;

public class Employee implements Comparable<Employee>{
    private final int salary;

    public Employee(int salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        if(this.salary > other.salary) return -1;
        else if (this.salary == other.salary) return 0;
        else return 1;
    }
}
