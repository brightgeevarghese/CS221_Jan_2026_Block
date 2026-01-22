package lesson3.day1.listimplstack;

import lesson3.day1.arrayimplstack.IStack;

import java.util.ArrayList;
import java.util.List;

public class ListStack<E> implements IStack<E> {

    private final List<E> list = new ArrayList<>();

    @Override
    public E push(E item) {
        return null;
    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean empty() {
        return false;
    }
}
