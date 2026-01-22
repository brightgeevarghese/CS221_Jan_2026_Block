package lesson2.day5.listiterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(
                List.of(
                        new Employee("John", 20),
                        new Employee("Michael", 40),
                        new Employee("Jane", 25)
                )
        );
        ListIterator<Employee> iterator = employees.listIterator();//this is not iterator()
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        //now traverse in the reverse direction
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }
        System.out.println();
        System.out.println(employees);
        iterator.add(new Employee("Bob", 30));
        System.out.println(employees);
        if (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        iterator.add(new Employee("Peter", 35));
        System.out.println(employees);
    }
}
class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
