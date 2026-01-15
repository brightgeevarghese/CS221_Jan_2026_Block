package lesson2.day3.singlylinkedlist;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        System.out.println(list);
        list.add(0, 100);
        System.out.println(list);
        list.add(list.size() - 1, 200);
        System.out.println(list);
        list.add(2, 300);
        System.out.println(list);
        list.addLast(400);
        System.out.println(list);
        System.out.println("Remove data from index 0: " + list.remove(0));
        System.out.println(list);
        System.out.println("Remove data from last: " + list.remove(list.size() - 1));
        System.out.println(list);
        System.out.println("Remove data from intermediate position, 2: " + list.remove(2));
        System.out.println(list);
    }
}
