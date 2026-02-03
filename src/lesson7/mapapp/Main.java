package lesson7.mapapp;

import java.util.*;

public class Main {

    public static double computeAverage(Map<Integer, Integer> valueMap) {
        double sum = 0;
        for (int value : valueMap.values()) {
            sum += value;
        }
        return sum / valueMap.size();
    }

    public static List<Double> computeSpans(NavigableMap<Integer, Integer> valueMap, int delta){
        List<Double> averages = new ArrayList<>();
        for (int i = valueMap.firstKey(); i <= valueMap.lastKey(); i += delta) {// i = 1962
            //pass a submap which consists of a delta number of elements
            double average = computeAverage(valueMap.subMap(i, true, i + delta, false));//i=1960=>1962
            System.out.println("Period [" + i + ", " + (i + delta - 1) + "] average: " + average + "");
            averages.add(average);
        }
        return averages;
    }

    public static void main(String[] args) {
        NavigableMap<Integer, Integer> valueMap = new TreeMap<>();
        valueMap.put(1960, 10);
        valueMap.put(1961, 5);
        valueMap.put(1962, 20);
        valueMap.put(1963, 8);
        valueMap.put(1964, 16);
        valueMap.put(1965, 50);
        valueMap.put(1966, 25);
        valueMap.put(1967, 15);
        valueMap.put(1968, 21);
        valueMap.put(1969, 13);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the delta: ");
        int delta = scanner.nextInt();
        System.out.println(computeSpans(valueMap, delta));
    }

}
