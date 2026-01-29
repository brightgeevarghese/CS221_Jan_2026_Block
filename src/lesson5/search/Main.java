package lesson5.search;

import java.util.Arrays;

public class Main {
    static int linearSearch(int[] arr, int key){
        return linearSearch(arr, key, 0);
    }
    private static int linearSearch(int[] arr, int key, int position) {
        if (position == arr.length) {
            return -1;
        }
        if (arr[position] == key) {
            return position;
        }
        return linearSearch(arr, key, position + 1);
    }

    static int binarySearch(int[] arr, int key){
        return binarySearch(arr, key, 0, arr.length - 1);
    }

    static int binarySearch(int[] arr, int key, int low, int high){
        if (low > high){
            return -1;
        }
        int mid = low + (high - low) / 2;//recommended to avoid integer overflow
        if (arr[mid] == key){
            return mid;
        }
        int cmp = Integer.compare(arr[mid], key);
        if (cmp < 0){
            return binarySearch(arr, key, mid + 1, high);
        } else {
            return binarySearch(arr, key, low, mid - 1);
        }
//        else if (arr[mid] < key){
//            return binarySearch(arr, key, mid + 1, high);//low = mid + 1
//        }else{
//            return binarySearch(arr, key, low, mid - 1);//high = mid - 1
//        }
    }

    void main() {
        int data[] = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(data, 50));
        //create an array of student object
        //it is sorted based on student mobile number
        //find a particular student based on mobile number using binary search - recursive method

//        int a[] = {10, 20, 12, 15, 25, 33};
//        int key = 12;
//        if (linearSearch(a, key) != -1) {
//            System.out.println("Found " + key + " at position " + linearSearch(a, key));
//        } else {
//            System.out.println("Not found");
//        }
    }
}
