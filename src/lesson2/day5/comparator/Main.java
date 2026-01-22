package lesson2.day5.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(
                List.of(
                        new Student("John", 28),
                        new Student("Adam", 40),
                        new Student("Peter", 30),
                        new Student("John", 25)
                )
        );
        System.out.println("Before sorting:");
        System.out.println(students);
//        Comparator<Student> nameComparator = new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getName().compareTo(o2.getName());
//            }
//        };
        //Sort based on name
        Collections.sort(students, Comparator.comparing(Student::getName).thenComparing(Student::getAge));

        Comparator<Student> nameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Student> ageComparator = (o1, o2) -> Integer.compare(o1.getAge(), o2.getAge());
        Collections.sort(
                students,
                nameComparator.thenComparing(ageComparator)
        );
        System.out.println("After sorting:");
        System.out.println(students);
        //Sort based on age
        Collections.sort(
                students,
                new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return Integer.compare(o1.getAge(), o2.getAge());
                    }
                }
        );
//        System.out.println(students);
    }
}
//class StudentNameComparator implements Comparator<Student> {
//
//    @Override
//    public int compare(Student o1, Student o2) {
//        return o1.getName().compareTo(o2.getName());
//    }
//}

//class StudentAgeComparator implements Comparator<Student>{
//    @Override
//    public int compare(Student o1, Student o2) {
//        return Integer.compare(o1.getAge(), o2.getAge());
//    }
//}