package packaging.simple;

public class Main {
    public static void main (String[] args) {
        Thing one = new Thing(4, "hi");
        System.out.println("one has the number " + one.getA());
        System.out.println("one has the string " + one.getB());
    }
}