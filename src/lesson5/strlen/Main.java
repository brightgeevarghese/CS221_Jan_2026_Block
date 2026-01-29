package lesson5.strlen;

public class Main {
    static int findLength(String s) {
        //base case
        if (s == "" || s == null) {
            return 0;
        }
        return 1 + findLength(s.substring(1));
    }
    //print char by char recursively
    static void printCharByChar(String s) {
        //write the base case
        if (s == "" || s == null) {
            return;
        }
        printCharByChar(s.substring(1));
        System.out.print(s.charAt(0) + " ");
    }
//    static int printCharBychar(String s){
//        if(s==""|| s==null){
//            return 0;
//        }
//        System.out.println(s.charAt(0));
//        return 1 + printCharBychar(s.substring(1));
//    }

    //find factorial using recursive
    static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    static int gcd(int m, int n) {
        if (m % n == 0) {
            return n;
        } else if (m < n) {
            //Assume m=20 and n=80
            return gcd(n, m);//gcd(80, 20)
        } else {
            //Imagine m = 12, n = 10
            //Then n = 10 and m = 12 % 10 = 2
            return gcd(n, m % n);
        }
    }

    static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    void main() {//JDK 25
        for (int i = 0; i <= 10; i++) {
            IO.print(fibonacci(i)+" ");
        }
//        System.out.println(factorial(-5));
//        IO.println( findLength("abc"));
//        IO.println(printCharBychar("apple"));
//        printCharByChar("apple");
    }
}
