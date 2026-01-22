package lesson2.day5.enhancedforloop;

import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> scores = List.of(10, 20, 30, 40);
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
        Iterator iterator = scores.iterator();
        //Java lambda => nameless function
//        iterator.forEachRemaining(data -> System.out.print(data + " "));
        System.out.println(iterator.next());
        System.out.println("for each remaining");
        iterator.forEachRemaining(System.out::println);


    }
}
