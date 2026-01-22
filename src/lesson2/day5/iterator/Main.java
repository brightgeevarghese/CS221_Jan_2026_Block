package lesson2.day5.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();//new ArrayList<>(List.of(11, 12, 13, 14));
        numbers.add(10);
        numbers.add(11);
        numbers.add(12);
        numbers.add(13);
        numbers.add(14);
        for (int i = 0; i < numbers.size(); i++) { //O(n)
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
        //Use Iterator object
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {//O(n)
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
//        System.out.println(iterator.next());//throws NoSuchElementException
        iterator = numbers.iterator();
        if (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(numbers);
    }
}
