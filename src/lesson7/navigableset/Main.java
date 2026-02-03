package lesson7.navigableset;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Main {
    void main() {
        NavigableSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(5);
        set.add(8);
        set.add(40);
        set.add(50);
        set.add(60);
        System.out.println(set);//[5, 8, 10, 40, 50, 60]
        //Returns a view of the portion of this set whose elements range from fromElement to toElement
        System.out.println(set.subSet(6, true, 40, true));//[8, 10, 40]
        System.out.println("First element is " + set.first());//5
        System.out.println("Last element is " + set.last());//60
        //Returns the greatest element in this set strictly less than the given element,
        // or null if there is no such element.
        System.out.println("Lower bound is " + set.lower(45));//40
        //Returns the least element in this set strictly greater than the given element,
        // or null if there is no such element.
        System.out.println("Upper bound is " + set.higher(45));//50
        //Retrieves and removes the first (lowest) element,
        // or returns null if this set is empty (optional operation).
        System.out.println(set.pollFirst());
        System.out.println("Current set after polling first: " + set);
    }
}
