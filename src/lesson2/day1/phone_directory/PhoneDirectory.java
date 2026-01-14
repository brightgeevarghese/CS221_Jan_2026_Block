package lesson2.day1.phone_directory;

public class PhoneDirectory {
    private String name;
    private String phoneNumber;

    public PhoneDirectory(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneDirectory{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
