public class MyDate {

  public int month;
  public int day;
  public int year;
  public static final int DPY = 365;
  public static final int DPLY = 366;
  //months from 1-12
  //days from 1-31
  //no limits on years

  public static String[] months = {"Jan", "Feb", "March", "April", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
  public static int[] dpm = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  public MyDate() {
    month = 1;
    day = 1;
    year = 0;
  }

  public MyDate(int month, int day, int year) {
    this.year = year;
    this.month = month;
    if (this.month > 12) {
      this.month = 12;
    } else if (this.month < 1) {
      this.month = 1;
    }

    this.day = day;
    if (this.day < 1) {
      this.day = 1;
    } else if (this.day > getDaysInMonth(this.month, this.year)) {
      this.day = getDaysInMonth(this.month, this.year);
    }

  }

  public static int getDaysInMonth (int m, int y) {
    int rv = dpm[m - 1];
    if (isYearLeap(y) && m == 2) {
      return 29;
    }
    return rv;
  }

  public static boolean isYearLeap (int y) {
    if (y % 4 == 0) {
      if (y % 100 == 0) {
        if (y % 400 == 0) {
          return true;
        } else {
          return false;
        }
      } else {
        return true;
      }
    }
    return false;
  }

  public static String monthName (MyDate d) {
    return months[d.month - 1];
  }

  public static String dateToString (MyDate d) {
    String rv = "";

    rv += monthName(d);
    rv += " " + d.day;
    rv += ", " + d.year;

    return rv;
  }
}