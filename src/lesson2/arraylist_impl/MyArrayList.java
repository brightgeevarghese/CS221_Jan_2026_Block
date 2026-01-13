package lesson2.arraylist_impl;

import java.util.Arrays;

public class MyArrayList<E> {
    private E[] elements;
    private int size;
    int capacity;

    public MyArrayList(int initialCapacity) {
        capacity = initialCapacity;
        elements = (E[]) new Object[capacity];
        size = 0;
    }

    public  boolean add(E data) {
        if (size == capacity) {
            reallocate();
        }
        elements[size++] = data;
        return true;
    }

    private void reallocate() {
        E[] newElements = (E[]) new Object[capacity * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(3);
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println(list);
        list.add(40);
        System.out.println(list);
    }
}