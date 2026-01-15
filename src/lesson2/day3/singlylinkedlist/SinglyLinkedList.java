package lesson2.day3.singlylinkedlist;

public class SinglyLinkedList<E> {

    private Node head;
    private int size;

    private class Node{
        private final E data;
        private Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    /***
     * This method returns the size of the list
     * @return an integer representing the size of the list
     */
    public int size() {
        return size;
    }

    public void addFirst(E e) {
        //create node
        Node newNode = new Node(e);
        if(head == null){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void add(int index, E element) {
//        System.out.println("Index: " + index + ", Size: " + size);
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(element);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node(element);
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public void addLast(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        if (head == null) {
            return null;
        } else {
            Node current = head;
            if (index == 0) {
                if (size == 1) {
                    Node oldData = head;
                    head = null;
                    size--;
                    return oldData.data;
                } else {
                    head = head.next;
                    E oldData = current.data;
                    current.next = null;
                    size--;
                    return oldData;
                }
            } else {
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                Node oldData = current.next;
                current.next = current.next.next;
                size--;
                return oldData.data;
            }

        }
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size() - 1);
    }
    @Override
    public String toString() {
        if (head == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node temp = head;
        while (temp != null){
            sb.append(temp.data);
            temp = temp.next;
            if (temp != null) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

