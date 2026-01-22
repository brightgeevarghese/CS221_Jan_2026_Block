package lesson4.singlylink;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.Queue;

public class SLQueue<E> extends AbstractQueue<E> implements Queue<E> {

    private class Node {
        private E data;
        private Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    @Override
    public Iterator<E> iterator() {
        return new SLQIterator();
    }

    private class SLQIterator implements Iterator<E>{

        private Node current = front;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(E e) {
        Node newNode = new Node(e);
        if (front == null) {//size == 0
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (size > 0) {
            E data = front.data;
            front = front.next;
            size--;
            return data;
        }
        return null;
    }

    @Override
    public E peek() {
        if (size > 0) {
            return front.data;
        }
        return null;
    }
}
