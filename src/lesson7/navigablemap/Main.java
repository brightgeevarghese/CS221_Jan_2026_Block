package lesson7.navigablemap;

import java.util.NavigableMap;
import java.util.TreeMap;

public class Main {
    void main() {
        NavigableMap<Integer, String> map = new TreeMap<>();
        map.put(10, "A");
        map.put(5, "B");
        map.put(8, "C");
        map.put(40, "D");
        map.put(20, "E");
        map.put(30, "F");
        System.out.println(map);//{5=B, 8=C, 10=A, 20=E, 30=F, 40=D}
        //Returns a view of the portion of this map whose keys are strictly less than toKey.
        System.out.println(map.headMap(20));//{5=B, 8=C, 10=A}
        System.out.println(map.headMap(20, true));//{5=B, 8=C, 10=A, 20=E}
        //Returns a view of the portion of this map whose keys are greater than or equal to fromKey
        System.out.println(map.tailMap(20));//{20=E, 30=F, 40=D}
        System.out.println(map.tailMap(20, false));//{30=F, 40=D}
        System.out.println(map.subMap(2, true, 25, true));//{5=B, 8=C, 10=A, 20=E}
    }
}
