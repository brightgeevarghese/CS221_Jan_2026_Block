package lesson7.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    void main() {
        Set<String> ugCourses = new HashSet<>();
        ugCourses.add("CS221");
        ugCourses.add("CS390");//FPP
        System.out.println("Adding CS203 for the first time : " + ugCourses.add("CS203"));
        System.out.println("Adding again CS203: " + ugCourses.add("CS203"));
        ugCourses.add("CS363");//CN
        System.out.println(ugCourses);//[CS203, CS363, CS221, CS390]
        ugCourses.remove("CS221");
        System.out.println("UG Courses: " + ugCourses);//[CS203, CS363, CS390]

        Set<String> gCourses = new HashSet<>();
        gCourses.add("CS390");
        gCourses.add("CS421");
        gCourses.add("CS401");
        gCourses.add("CS473");//MDP
        System.out.println("Grad. Courses: " + gCourses);

        //union
//        ugCourses.addAll(gCourses);
//        System.out.println(ugCourses);
        //intersection
//        ugCourses.retainAll(gCourses);//CS390
//        System.out.println(ugCourses);
        //member check
//        System.out.println(ugCourses.contains("CS390"));
        //subsets check
//        System.out.println(gCourses.containsAll(ugCourses));
        //difference
        System.out.println(gCourses.removeAll(ugCourses));
        System.out.println("After difference:");
        System.out.println("UG Courses: " + ugCourses);
        System.out.println("Grad. Courses: " + gCourses);
        //Display set using for each
        for (String course : ugCourses) {
            System.out.println(course);
        }
        //Display using iterator
        Iterator<String> itr = ugCourses.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
