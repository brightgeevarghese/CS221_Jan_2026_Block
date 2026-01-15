package lesson2.day2.linearsearch;

import java.util.Scanner;

public class Main {
    static int linearSearch(int[] arr, int key){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 8, 11, 12, 88, 1, 2};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target to be searched: ");
        int target = sc.nextInt();
        long startTime = System.nanoTime();
        int position = linearSearch(arr, target);
        long elapsedNanos = System.nanoTime() - startTime;
        System.out.println("Time taken: " + elapsedNanos + " nanoseconds.");
        if (position != -1) {
            System.out.println("The " + target + " is found at position: " + linearSearch(arr, target) + ".");
        } else {
            System.out.println("The " + target + " is not available in the data set.");
        }
    }
}
