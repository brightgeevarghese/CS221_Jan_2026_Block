package lesson7.hashtable.chaining;

import java.util.Arrays;

public class HashTableChaining {
    private class Item {
        private int key;
        private String value;
        public Item(int key, String value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return key + " - " + value;
        }
    }
    private class Node{
        private Item item;
        private Node next;
        public Node(Item item, Node next) {
            this.item = item;
            this.next = next;
        }

        @Override
        public String toString() {
            return item +
                    ", next=" + next;//since next contains ref of another Node object, it calls next.toString();
        }
    }
    private Node[] table;//A collection of linked list
    //table[0] -> first linked list => table[0] = first node of the linkedlist
    //table[1] -> second linked list
    int size;
    public static final double MAX_LOAD_FACTOR = 0.75;
    public HashTableChaining(int initialCapacity){
        table = new Node[initialCapacity];
    }
    private int hash(int key){
        return key % table.length;
    }
    private void rehash() {
        Node[] oldTable = table;
        table = new Node[2 * oldTable.length];
        size = 0;
        for (Node row : oldTable) {
            while (row != null) {
                put(row.item.key, row.item.value);
                row = row.next;
            }
        }
        System.out.println("Rehashing completed.");
    }
    public void put(int key, String value){
        double loadFactor = (double) size / table.length;
        System.out.println( "Load factor: " + loadFactor);
        if (loadFactor > MAX_LOAD_FACTOR) {
            System.out.println( "Rehashing for " + value);
            rehash();
        }
        int index = hash(key);
        Node current = table[index];
        if (current == null){
            table[index] = new Node(new Item(key, value), null);
        } else {
            //check whether the key is already existing
            while (current != null){
                if (current.item.key == key){
                    current.item.value = value;
                    return;
                }
                current = current.next;
            }
            //add a new node to the beginning of the linked list
            Node newNode = new Node(new Item(key, value), null);
            newNode.next = table[index];//the new node's next points to the first node of the list
            table[index] = newNode;//make the new node as the first node of the list
        }
        size++;
    }
    public String get(int key){
        int index = hash(key);
        Node current = table[index];
        while (current != null){
            if (current.item.key == key){
                return current.item.value;
            }
            current = current.next;
        }
        return null;//key not found
    }

    public boolean contains(int key){
        return get(key) != null;
    }

    public String remove(int key){
        //find the index by using the hash function
        int index = hash(key);
        //If table[index] is not null, remove the node which contains key
        Node current = table[index];
        Node previous = null;
        while (current != null){
            if (current.item.key == key) {
                //we found the node to be removed
                //previous node's next' = current.next
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return current.item.value;
            }
            previous = current;
            current = current.next;
        }
        return null;//If table[index] is null, return null
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node row: table) {//row contains value of starting node
            sb.append(row).append("\n");
        }
        return sb.toString();
    }
}

class Main {
    public static void main(String[] args) {
        HashTableChaining hashTableChaining = new HashTableChaining(5);
        hashTableChaining.put(10, "Apple");
        hashTableChaining.put(20, "Banana");
        hashTableChaining.put(12, "Orange");
        hashTableChaining.put(22, "Grapes");
        hashTableChaining.put(15, "Mango");
//        hashTableChaining.put(32, "Pineapple");
//        hashTableChaining.put(26, "Strawberry");
//        hashTableChaining.put(11, "Cherry");
//        hashTableChaining.put(14, "Pear");
        System.out.println(hashTableChaining);
//        System.out.println(hashTableChaining.get(12) + " is found.");//Orange
//        if (hashTableChaining.contains(11)) {
//            System.out.println("11 is found.");
//        } else {
//            System.out.println("11 is not found.");
//        }
//        System.out.println("Removing 20: " + hashTableChaining.remove(20));
//        System.out.println(hashTableChaining);
    }
}