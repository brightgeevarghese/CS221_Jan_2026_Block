package lesson4.pq;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Employee>  pq = new PriorityQueue<>(
                new Comparator<Employee>() {
                    @Override
                    public int compare(Employee o1, Employee o2) {
                        return Integer.compare(o1.getRank(),  o2.getRank());
                    }
                }
        );
        pq.offer(new Employee(3, "Dave"));
        pq.offer(new Employee(4, "John"));
        pq.offer(new Employee(2, "David"));
        pq.offer(new Employee(5, "John"));
        while (!pq.isEmpty()) {
            Employee e = pq.poll();
            System.out.println(e);
        }
    }
}

class Employee {
    private int rank;
    private String name;
    public Employee(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                '}';
    }


}
