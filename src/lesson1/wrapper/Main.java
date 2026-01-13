package lesson1.wrapper;

public class Main {
    public static void main(String[] args) {
        int data = 10;
        Integer iob = Integer.valueOf(data);//Manual boxing
        Integer iob1 = 10;//Automatic boxing//Integer.valueOf(10);
//        Integer iob2 = new Integer(100);
        System.out.println(iob);//automatic unboxing
        System.out.println(iob.intValue());//manual unboxing
    }
}
