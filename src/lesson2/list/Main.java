package lesson2.list;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Instantiate ArrayList
        List<Integer> list = new ArrayList<>();//initial capacity is 10
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);//toString()
        //Access data based on index
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //Enhanced for loop
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
