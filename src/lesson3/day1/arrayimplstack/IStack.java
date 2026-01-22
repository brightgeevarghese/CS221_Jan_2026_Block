package lesson3.day1.arrayimplstack;

public interface IStack<E> {
    E push(E item);
    E pop();
    E peek();
    boolean empty();
}
