package lesson7.map;

import java.util.HashMap;
import java.util.Map;

public class Main {
    void main() {
        Map<Character, String> fruits = new HashMap<>();
        fruits.put('a', "🍏Apple");
        fruits.put('b', "Banana");
        fruits.put('c', "Cherry");
        fruits.put('d', "Durian");
        System.out.println(fruits);
        System.out.println(fruits.get('a'));
        System.out.println(fruits.remove('a') + " removed ");
        System.out.println(fruits);
    }
}
