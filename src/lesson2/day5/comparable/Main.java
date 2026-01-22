package lesson2.day5.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(//a collection of Integer objects
                List.of(10, 8, 11, 9)
        );
        //sort the list
//        Collections.sort(list);
//        System.out.println(list);
        //Create a list of employees
        List<Employee> employees = new ArrayList<>(
                List.of(
                        new Employee("John", 23),
                        new Employee("Adam", 13),
                        new Employee("Bob", 33),
                        new Employee("Dave", 22)
                )
        );
        Collections.sort(employees);
        System.out.println(employees);
    }
}
class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return name + "-" + age;
    }

    @Override
    public int compareTo(Employee o) {
        //sorting decision
//        return Integer.compare(age, o.age);
        return this.name.compareTo(o.name);
    }
}
