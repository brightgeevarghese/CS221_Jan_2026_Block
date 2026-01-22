package lesson4.circularq;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Iterator;

public class CircularQ<E>  extends AbstractQueue<E> {

    private E[] data;
    private int front = 0;
    private int rear = -1;
    private int size;
    private final int INITIAL_CAPACITY = 5;
    private int capacity;

    public CircularQ() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
    }

    @Override
    public Iterator<E> iterator() {
        return new CircularQIterator();
    }

    private class CircularQIterator implements Iterator<E>{

        private int index = front;
        private int count = 0;

        @Override
        public boolean hasNext() {
            return count < size;
        }

        @Override
        public E next() {
            count++;
            E element = data[index];
            index = (index + 1) % capacity;
            return element;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean offer(E e) {
        if (size == capacity) {
            //reallocate
            reallocate();
        }
        data[++rear] = e;
        size++;
        return true;
    }

    private void reallocate() {
        System.out.println( "Reallocating...");
        E[] newData = (E[]) new Object[capacity * 2];
        int current = front;
        for (int i = 0; i < size; i++) {
            newData[i] = data[current];
            current = (current + 1) % capacity;
        }
        data = newData;
        capacity *= 2;
        front = 0;
        rear = size - 1;
    }

    @Override
    public E poll() {
        if (size > 0) {
            E removedData = data[front];
            data[front] = null;
            front = (front + 1) % capacity;
            size--;
            if (size == 0) {
                //reset front and rear
                front = 0;
                rear = -1;
            }
            return removedData;
        }
        return null;
    }

    @Override
    public E peek() {
        if (size > 0) {
            return data[front];
        }
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}

class Main {
    public static void main(String[] args) {
        CircularQ<Integer> circularQ = new CircularQ<>();
        circularQ.offer(10);
        circularQ.offer(20);
        circularQ.offer(30);
        circularQ.offer(40);
        circularQ.offer(50);
        circularQ.offer(60);
        System.out.println(circularQ);
        System.out.println(circularQ.poll());
        System.out.println(circularQ);
        System.out.println("Iterating:");
        Iterator<Integer> iterator = circularQ.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}