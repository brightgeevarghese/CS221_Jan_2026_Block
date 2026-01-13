package lesson1.inheritance;

public class Main {
    public static void main(String[] args) {
        Computer computer =
                new Computer("Acer", "Intel Core i7", 8, 512, 2.6);
        System.out.println(computer);
        NoteBook notebook =
                new NoteBook(
                        "Acer",
                        "Intel Core i7",
                        16, 512,
                        3.6,
                        15.6,
                        0.5);
        System.out.println(notebook);
        System.out.println("Compute power for computer: " + computer.computePower());
        System.out.println("Compute power for notebook: " + notebook.computePower());
//        System.out.println(Double.compare(computer.computePower(), notebook.computePower()));
        System.out.println(notebook.compareComputePower(computer));
        System.out.println(computer.compareComputePower(notebook));
        Computer computer1 = new NoteBook("Intel Core i7", 8, 512, 3.6, 15.6, 0.5);
//        System.out.println(computer1.toString());//computer1.toString()
        computer1.f1();//
    }
}
