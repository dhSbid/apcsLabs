public class MyTime {
  
  int h, m, s;
  boolean isAm;

  public static final int S_PER_M = 60;
  public static final int M_PER_H = 60;
  public static final int S_PER_H = S_PER_M * M_PER_H;

  public MyTime () {
    h = 0;
    m = 0;
    s = 0;
    isAm = true;
  }

  public MyTime (int h, int m, int s, boolean isAm)
  {
    //If using this class, only pass 0-11
    this.h = h;
    this.m = m;
    this.s = s;
    this.isAm = isAm;
  }
}