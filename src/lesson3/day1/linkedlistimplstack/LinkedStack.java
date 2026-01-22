package lesson3.day1.linkedlistimplstack;

import lesson3.day1.arrayimplstack.IStack;

import java.util.EmptyStackException;

public class LinkedStack<E> implements IStack<E> {

    private class Node {
        private final E data;
        private Node next;
        public Node(E data) {
            this.data = data;
        }
    }

    private Node top;

    @Override
    public E push(E item) {
        Node newNode = new Node(item);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        return item;
    }

    @Override
    public E pop() {
        if (!empty()) {
            E removedItem = top.data;
            top = top.next;
            return removedItem;
        }
        throw new EmptyStackException();
    }

    @Override
    public E peek() {
        if (!empty()) {
            return top.data;
        }
        throw new EmptyStackException();
    }

    @Override
    public boolean empty() {
        return top == null;
    }
}
class Main {
    public static void main(String[] args) {
        IStack<Integer> stack = new LinkedStack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.peek());
        System.out.println("Removing elements: ");
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}