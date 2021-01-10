package packaging.simple;

public class Thing {
    int a;
    String b;

    public Thing () {
        a = 0;
        b = "";
    }

    public Thing (int a, String b) {
        this.a = a;
        this.b = b;
    }

    public int getA () {
        return a;
    } 

    public String getB () {
        return b;
    }

    public void setA (int a) {
        this.a = a;
    }

    public void setB (String b) {
        this.b = b;
    }
}