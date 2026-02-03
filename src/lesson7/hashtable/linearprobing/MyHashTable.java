package lesson7.hashtable.linearprobing;

import java.util.Arrays;

public class MyHashTable {
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
    private Item[] table;
    private int size = 0;
    private Item nonItem = new Item(-1, null);

    public MyHashTable(int arraySize) {
        this.table = new Item[arraySize];
    }

    private int hash(int key){
        return key % table.length;
    }
    public void put(int key, String value){
        int index = hash(key);
        while (table[index] != null && table[index] != nonItem){
            //If the key already existing
            if (table[index].key == key){
                table[index].value = value;
                return;
            }
            index = (index + 1) % size;
        }
        table[index] = new Item(key, value);
    }
    public String get(int key){
        int index = hash(key);
        int startIndex = index;
        while (table[index] != null && table[index] != nonItem){
            if (table[index].key == key){
                return table[index].value;
            }
            index = (index + 1) % size;
            if (index == startIndex){
                break;//throw new NosuchElementException("No such element");
            }
        }
        return null;
    }

    public String remove(int key){
        int index = hash(key);
        int startIndex = index;
        while (table[index] != null && table[index] != nonItem){
            if (table[index].key == key){
                String value = table[index].value;
                table[index] = nonItem;
                return value;
            }
            index = (index + 1) % size;
            if (index == startIndex) {
                break;//throw new NosuchElementException("No such element");
            }
        }
        return null;
    }
    public boolean contains(int key){
        return get(key) != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : table) {
            if (item == null) continue;
            if (item.key == -1) continue;
            sb.append(item).append(", ");
        }
        sb.setLength(sb.length() - 2);
        return sb.toString();
    }
}
class Main {
    static void main() {
        MyHashTable hashTable = new MyHashTable(5);
        hashTable.put(10, "A");
        hashTable.put(11, "B");
        hashTable.put(13, "C");
        hashTable.put(40, "D");
//        hashTable.put(50, "E");
        System.out.println(hashTable);
        System.out.println(hashTable.get(10));
        System.out.println(hashTable.remove(11));
        System.out.println(hashTable);
        System.out.println(hashTable.contains(11));//false(Already removed)
    }
}
