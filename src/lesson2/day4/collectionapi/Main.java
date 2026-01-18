package lesson2.day4.collectionapi;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        //Add at the end of the LinkedList
        employees.add(new Employee("John", 20));
        employees.add(new Employee("Jane", 25));
        employees.add(new Employee("Peter", 30));
//        System.out.println(employees);
//        employees.addFirst(new Employee("Michael", 40));
//        System.out.println(employees);
//        employees.addLast(new Employee("Johny", 30));
//        System.out.println(employees);
//        System.out.println(employees.removeFirst() + " is removed from the list");
//        System.out.println(employees);
//        System.out.println(employees.removeLast() + " is removed from the list");
//        System.out.println(employees);
//        System.out.println(employees.set(1, new Employee("Tommy", 25)) + " is replaced with Tommy");
//        System.out.println(employees);
//        System.out.println("The size of the list is " + employees.size());
//        System.out.println("Traversing the list in forward direction: ");
//        for (Employee employee : employees) {
//            System.out.print(employee + " ");
//        }
        employees.add(new Employee("Alice", 101));
        employees.add(new Employee("Bob", 102));
        employees.add(new Employee("Charlie", 103));

        Iterator<Employee> itr1 = employees.iterator();
        while (itr1.hasNext()) {
            System.out.print(itr1.next() + " ");
        }
        System.out.println("\nTraversing the list in reverse direction: ");
        Iterator<Employee> itr = employees.descendingIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        //Use reversed()
        System.out.println(employees.reversed());
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
        return name + "-" + age;
    }
}




