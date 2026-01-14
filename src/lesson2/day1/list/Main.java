package lesson2.day1.list;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Instantiate ArrayList
//        List<Integer> list = new ArrayList<>();//initial capacity is 10
//        list.add(10);
//        list.add(20);
//        list.add(30);
//        System.out.println(list);//toString()
//        //Access data based on index
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        //Enhanced for loop
//        for (Integer i : list) {
//            System.out.println(i);
//        }
//        //Remove a data from index 2
//        list.remove(2);
//        System.out.println("After removing data from index 2: " + list);
////        System.out.println(list.remove(20));//Error
//        System.out.println(list.remove(Integer.valueOf(20)));
//        System.out.println(list);
//        System.out.println("Size of list is " + list.size());
        //Create a list of Employee objects
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 30));
        employees.add(new Employee("Jane", 25));
        employees.add(new Employee("Michael", 40));
        System.out.println(employees);
        //Remove John from the list by using index
        System.out.println(employees.remove(0));
        System.out.println(employees);
        //Remove Michael from the list by using object
        System.out.println(employees.remove(employees.get(1)));//Good
        System.out.println(employees.remove(new Employee("Michael", 40)));
        System.out.println(employees);
        employees.add(new Employee("Johny", 30));
        System.out.println(employees);
        employees.add(1, new Employee("Tommy", 25));
        System.out.println(employees);
    }
}
