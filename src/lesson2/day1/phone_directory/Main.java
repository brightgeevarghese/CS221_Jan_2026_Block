package lesson2.day1.phone_directory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<PhoneDirectory> list = List.of(
//                new PhoneDirectory("John", "0798654321"),
//                new PhoneDirectory("Jane", "0798654322")
//        );
        List<PhoneDirectory> directories = new ArrayList<>();
        directories.add(new PhoneDirectory("John", "0798654321"));
        directories.add(new PhoneDirectory("Jane", "0798654322"));
//        directories.forEach(System.out::println);//Java lambda
        System.out.println(directories);
        //how to remove the first directory
//        System.out.println(directories.remove(0));
//        System.out.println(directories.removeFirst());
        System.out.println(directories);
        directories.set(0, new PhoneDirectory("Timmy", "1234"));//modify
        System.out.println(directories);
    }
}
