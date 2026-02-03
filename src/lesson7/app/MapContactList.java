package lesson7.app;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapContactList implements ContactListInterface{
    private final Map<String, List<String>> contacts;

    public MapContactList() {
        contacts = new TreeMap<>();
    }
    @Override
    public List<String> addOrChangeEntry(String name, List<String> newNumbers) {
        return contacts.put(name, newNumbers);
    }

    @Override
    public List<String> lookupEntry(String name) {
        return contacts.get(name);
    }

    @Override
    public List<String> removeEntry(String name) {
        return contacts.remove(name);
    }

    @Override
    public void display() {
        for (Map.Entry<String, List<String>> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    void f1() {
        System.out.println("f1");
    }
}

class Main {
    void main() {
        ContactListInterface contactList = new MapContactList();
        contactList.addOrChangeEntry("John", List.of("1234567890"));
        contactList.addOrChangeEntry("Jane", List.of("12234", "2234567890"));
        contactList.addOrChangeEntry("John", List.of("1234567899", "1334567891"));
        contactList.display();
        System.out.println("Remove John: " + contactList.removeEntry("John"));
        contactList.display();
    }
}
