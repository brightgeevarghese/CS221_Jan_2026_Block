package lesson5.linkedlist;

public class SinglyLinkedList<E> {
    private class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
        }
    }
    private Node head;
    private int size;
    public int size() {
        return size;
    }
    public void addLast(E e) {
        Node newNode = new Node(e);
        if(head == null){
            head = newNode;
            return;
        } else {
            addLast(head, newNode);
        }
    }

    private void addLast(Node current, Node newNode) {
        if(current.next == null){
            current.next = newNode;
//            return;
        }else {
            addLast(current.next,newNode);
        }
    }

    public void display() {
        if(head == null){
            System.out.println("List is empty");
        } else {
            display(head);
        }
    }

    private void display(Node current) {
        System.out.print(current.data + " ");
        if(current.next != null){
            display(current.next);
        }
    }
}
class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.display();
    }
}