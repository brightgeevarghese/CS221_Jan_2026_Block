package lesson4.doublylinklist;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DLQueue<E> implements Queue<E> {

    private LinkedList<E> list = new LinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return list.add(e);
    }

    @Override
    public boolean remove(Object o) {
//        list.getFirst().equals(o)
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        return list.offer(e);
    }

    @Override
    public E remove() {
        return list.remove();
    }

    @Override
    public E poll() {
        return list.poll();
    }

    @Override
    public E element() {
        return list.getFirst();
    }

    @Override
    public E peek() {
        return list.peek();
    }
}

class Main {
    public static void main(String[] args) {
        DLQueue<Integer> dlQueue = new DLQueue<>();
        dlQueue.offer(10);
        dlQueue.offer(20);
        dlQueue.offer(30);
        dlQueue.offer(40);
        while (!dlQueue.isEmpty()) {
            System.out.println(dlQueue.poll());
        }
    }
}