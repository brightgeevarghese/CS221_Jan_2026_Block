package lesson2.day1.arraylist_impl;

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

    public void add(int index, E data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == capacity) {
            reallocate();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = data;
        size++;
    }

    private void reallocate() {
//        System.out.println("Reallocating...");
        E[] newElements = (E[]) new Object[capacity * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
        capacity *= 2;
    }

    public int size() {
        return size;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removed = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removed;
    }

    public E set(int index, E data) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldData = elements[index];
        elements[index] = data;
        return oldData;
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
        list.add(0, 50);
        System.out.println(list);
        list.add(4, 60);
        System.out.println(list);
        System.out.println(list.size());
        list.add(3, 70);
        System.out.println(list);
//        list.add(100, 23);
        System.out.println("Remove data from index 0: " + list.remove(0));
        System.out.println(list);
        System.out.println(list.set(2, 80));
        System.out.println(list);
    }
}