package lesson2.day2.binarysearch;

public class Main {
    static int binarySearch(int[] arr, int key){
        int low = 0;
        int high = arr.length - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] == key){
                return mid;
            }else if (arr[mid] < key){
                //choose the right side
                low = mid + 1;
            }else {
                //choose the left side
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] scores = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int target = 100;//dynamically feed the data by using Scanner class method, nextInt()
        long startTime = System.nanoTime();
        int position = binarySearch(scores, target);
        long elapsedNanos = System.nanoTime() - startTime;
        System.out.println("Time taken: " + elapsedNanos + " nanoseconds.");
        if ( position!= -1) {
            System.out.println("The data " + target + " is found " + "at position: " + position + ".");
        } else {
            System.out.println("The data " + target + " is not found.");
        }
    }
}
