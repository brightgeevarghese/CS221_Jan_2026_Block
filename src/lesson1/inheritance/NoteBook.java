package lesson1.inheritance;

public class NoteBook extends Computer{
    private double screenSize;
    private double weight;

    public NoteBook(String manufacturer, String processor, int ramSize, int diskSize, double processorSpeed, double screenSize, double weight) {
        super(manufacturer, processor, ramSize, diskSize, processorSpeed);
        this.screenSize = screenSize;
        this.weight = weight;
    }
    public NoteBook(String processor, int ramSize, int diskSize, double processorSpeed, double screenSize, double weight) {
        super("DELL", processor, ramSize, diskSize, processorSpeed);
        this.screenSize = screenSize;
        this.weight = weight;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "NoteBook{" +
                super.toString() +
                "screenSize=" + screenSize +
                ", weight=" + weight +
                '}';
    }

    void f1(){
        System.out.println("f1 from NoteBook");
    }
}
