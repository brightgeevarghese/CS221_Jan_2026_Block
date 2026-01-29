package lesson6.api.treeset;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    void main() {
        Set<Employee> employees = new TreeSet<>();
        employees.add(new Employee(101, "John"));
        employees.add(new Employee(98, "Jane"));
        employees.add(new Employee(100, "Jack"));
        employees.add(new Employee(101, "John"));
        System.out.println(employees);
        System.out.println(employees.add(new Employee(20, "Jack")));
        System.out.println(employees);
    }
}

class Employee implements Comparable<Employee> {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.name);
    }
}
