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

    public int size() {
        return size;
    }

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
        size++;
    }

    public void displayForward() {
        if (head == null) {
            System.out.println( "List is empty");
            return;
        }
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward() {
        if (head == null) {
            System.out.println( "List is empty");
            return;
        }
        Node current = tail;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public void addLast(E e) {
        Node newNode = new Node(e);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;//lastnode.next = newNode
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, E element) {
        System.out.println("Index: " + index + ", Size: " + size);
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        if (index == 0) {
            addFirst(element);
        } else  {
            Node newNode = new Node(element);
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            //insert and shift the element
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public E removeFirst() {
        if (head == null) {
            return null;
        } else {
            E data = head.data;
            head = head.next;
            head.prev = null;
            size--;
            return data;
        }
    }

    public E removeLast() {
        if (head == null) {
            return null;
        } else {
            E data = tail.data;
            tail = tail.prev;//2nd last data
            tail.next = null;
            size--;
            return data;
        }
    }



    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        if (head == null) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size() - 1) {
            return removeLast();
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            System.out.println( "Removing: " + current.data);
            E data = current.data;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.next = null;
            current.prev = null;
            size--;
            return data;
        }
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
        list.addLast(40);
        list.displayForward();//30 20 10 40
        list.displayBackward();//40 10 20 30
        list.add(0, 50);
        list.displayForward();
        list.displayBackward();
        list.add(1, 60);
        list.displayForward();
        list.displayBackward();
        list.add(list.size() - 1, 606);
        list.displayForward();
        list.displayBackward();
        System.out.println(list.removeFirst());
        list.displayForward();
        list.displayBackward();
        System.out.println(list.remove(1));
        list.displayForward();
        list.displayBackward();
    }
}