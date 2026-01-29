package lesson4.pq;//package lesson4.pq;
//
//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//public class Main {
//    public static void main(String[] args) {
//        PriorityQueue<Employee>  pq = new PriorityQueue<>(
//                new Comparator<Employee>() {
//                    @Override
//                    public int compare(Employee o1, Employee o2) {
//                        return Integer.compare(o1.getRank(),  o2.getRank());
//                    }
//                }
//        );
//        pq.offer(new Employee(3, "Dave"));
//        pq.offer(new Employee(4, "John"));
//        pq.offer(new Employee(2, "David"));
//        pq.offer(new Employee(5, "John"));
//        while (!pq.isEmpty()) {
//            Employee e = pq.poll();
//            System.out.println(e);
//        }
//    }
//}
//
//class Employee {
//    private int rank;
//    private String name;
//    public Employee(int rank, String name) {
//        this.rank = rank;
//        this.name = name;
//    }
//
//    public int getRank() {
//        return rank;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee{" +
//                "rank=" + rank +
//                ", name='" + name + '\'' +
//                '}';
//    }
//
//
//}
//import java.util.PriorityQueue;
//
//public class Main {
//    public static void main(String[] args) {
//
//        // TODO: Create a PriorityQueue that orders patients
//        // based on severity (ascending)
//
//        PriorityQueue<Patient> pq = new PriorityQueue<>( /* write code here */ );
//
//        // Do NOT change below this line
//        pq.offer(new Patient(3, "Tom"));
//        pq.offer(new Patient(1, "Alice"));
//        pq.offer(new Patient(4, "John"));
//        pq.offer(new Patient(2, "Mary"));
//
//        while (!pq.isEmpty()) {
//            Patient p = pq.poll();
//            System.out.println(
//                    "Treating: " + p.getName() +
//                            " | Severity: " + p.getSeverity()
//            );
//        }
//    }
//}
//
//class Patient {
//    private int severity;
//    private String name;
//
//    public Patient(int severity, String name) {
//        this.severity = severity;
//        this.name = name;
//    }
//
//    public int getSeverity() {
//        return severity;
//    }
//
//    public String getName() {
//        return name;
//    }
//}

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Iterator;

class CircularQ<E>  extends AbstractQueue<E> {

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
        //Write code here

        return true;
    }

    private void reallocate() {
        //Write code here
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
        lesson4.circularq.CircularQ<Integer> circularQ = new lesson4.circularq.CircularQ<>();
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