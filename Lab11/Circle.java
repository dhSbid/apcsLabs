public class Circle {
  public double x, y;
  public double r;

  public Circle() {
    x = 0;
    y = 0;
    r = 0;
  }

  public Circle(double x, double y, double r) {
    this.x = absVal(x);
    this.y = absVal(y);
    this.r = absVal(r);
  }

  public static double absVal (double a) {
    if (a < 0) {
      return -a;
    }
    return a;
  }

}