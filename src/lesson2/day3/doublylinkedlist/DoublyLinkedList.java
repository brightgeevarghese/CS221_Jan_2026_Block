package lesson2.day3.doublylinkedlist;

public class DoublyLinkedList<E> {
    private class Node{
        private final E data;
        private Node prev;
        private Node next;

        public Node(E data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(E e) {
        Node newNode = new Node(e);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void displayForward() {
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        Node current = tail;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.displayForward();//30 20 10
        list.displayBackward();//10 20 30
    }
}