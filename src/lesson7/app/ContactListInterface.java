package lesson7.app;

import java.util.List;

public interface ContactListInterface {
    List<String> addOrChangeEntry(String name, List<String> newNumbers);
    List<String> lookupEntry(String name);
    List<String> removeEntry(String name);
    void display();
}
