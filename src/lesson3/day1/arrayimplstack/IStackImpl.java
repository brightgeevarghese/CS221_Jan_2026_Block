package lesson3.day1.arrayimplstack;

import java.util.EmptyStackException;

public class IStackImpl<E> implements IStack<E>{
    private E[] items;
    private int size;
    private final int INITIAL_CAPACITY = 3;
    private int capacity;
    private int top = -1;
    public IStackImpl() {
        items = (E[]) new Object[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
    }
    @Override
    public E push(E item) {
        //check stack is full or not
        if (top == items.length - 1) {
            //resize stack
            resize();
        }
        items[++top] = item;
        return item;
    }

    public void resize() {
        E[] newItems = (E[]) new Object[capacity * 2];
        System.arraycopy(items, 0, newItems, 0, items.length);
        items = newItems;
        capacity *= 2;
    }

    @Override
    public E pop() {
        if (!empty()) {
            E removedItem = items[top];
            items[top--] = null;
            return removedItem;
//            return items[top--];
        }
        throw new EmptyStackException();
    }

    @Override
    public E peek() {
        if (!empty()) {
            return items[top];
        }
        throw new EmptyStackException();
    }

    @Override
    public boolean empty() {
        return top == -1;
    }
}

class Main {
    public static void main(String[] args) {
        IStack<Integer> stack = new IStackImpl<>();//Dynamic polymorphism(Dynamic method dispatch)
        //stack.resize();//error
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}