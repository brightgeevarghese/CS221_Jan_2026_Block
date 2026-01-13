package lesson1.abstract_demo;

public abstract class Person {
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public abstract void details();
}

class Student extends Person{
    private String studentId;

    public Student(String studentId, String name, int age) {
        super(name, age);
        this.studentId = studentId;
    }

    @Override
    public void details() {

    }
}
class Main{
    public static void main(String[] args) {
        Person p = new Student("123456789", "John", 20);
        System.out.println(p);
    }
}