package lesson4.maintaincustomers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaintainQueue {
    private Queue<Customer> customers;
    private Scanner scanner = new Scanner(System.in);

    public MaintainQueue() {
        this.customers = new LinkedList<>();
    }

    private void showMenu() {
        System.out.println("1. Add Customer");
        System.out.println("2. Remove Customer");
        System.out.println("3. Peek first customer");
        System.out.println("4. Queue size");
        System.out.println("5. No. of people ahead of a customer");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
    public void processCustomer() {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    removeCustomer();
                    break;
                case 3:
                    peekCustomer();
                    break;
                case 4:
                    queueSize();
                    break;
                case 5:
                    peopleAhead();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    break;
            }
        } while(choice != 6);
    }

    private void peopleAhead() {
        if (customers.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Enter the email of customer: ");
        String email = scanner.next();
        int countAhead = 0;
        boolean found = false;
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                found = true;
                break;
            }
            countAhead++;
        }
        if (found) {
            System.out.println(countAhead + " people ahead of " + email);
        } else {
            System.out.println("Customer not found.");
        }
    }

    private void queueSize() {
        System.out.println("Queue size is: " + customers.size());
    }

    private void peekCustomer() {
        if (!customers.isEmpty()) {
            System.out.println(customers.peek() + " is at front/head of the queue.");
        } else {
            System.out.println("Queue is empty.");
        }
    }

    private void removeCustomer() {
        if (!customers.isEmpty()) {
            System.out.println(customers.poll() + " is removed from the queue.");
        } else {
            System.out.println("Queue is empty.");
        }
    }

    private void addCustomer() {
        System.out.println("Enter customer name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter customer email: ");
        String email = scanner.nextLine();
        customers.offer(new Customer(name, email));
    }
}

class Main {
    public static void main(String[] args) {
        MaintainQueue maintainQueue = new MaintainQueue();
        maintainQueue.processCustomer();
    }
}