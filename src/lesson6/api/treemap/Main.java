package lesson6.api.treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    void main() {
        Map<String, String> phoneBook = new TreeMap<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                }.reversed()
        );
        phoneBook.put("12345678", "John");
        phoneBook.put("98765432", "Jane");
        phoneBook.put("2345679", "Jack");
        System.out.println(phoneBook);

//        Set<Map.Entry<String, String>> entries = phoneBook.entrySet();
//        for (Map.Entry<String, String> entry : entries) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
//        Map.Entry<String, String> entry = phoneBook.entrySet().iterator().next();
//        System.out.println(entry.getKey() + " " + entry.getValue());
    }
}


