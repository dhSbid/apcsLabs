public class BankAccount {

    private double balance;
    private String name;
    private int accountNumber;
    private static int numberOfAccountsCreated = 0;
    public static final int BASE = 10000000;

    public BankAccount () {
        this.balance = 0;
        this.name = "";
        numberOfAccountsCreated++;
        this.accountNumber = BASE + numberOfAccountsCreated;

        if (numberOfAccountsCreated % 100 == 0) {
            this.balance += 100;
        }
    }

    public BankAccount (double balance, String name) {
        this.balance = balance;
        this.name = name;
        numberOfAccountsCreated++;
        this.accountNumber = BASE + numberOfAccountsCreated;

        if (numberOfAccountsCreated % 100 == 0) {
            this.balance += 100;
        }
    }

    public double getBalance () {
        return balance;
    }

    public String getName () {
        return name;
    }

    public int getAccountNumber () {
        return accountNumber;
    }

    public static int getNumberOfAccountsCreated () {
        return numberOfAccountsCreated;
    }

    public void setBalance (double newBal) {
        this.balance = newBal;
    }

    public void setName (String newName) {
        this.name = newName;
    }

    @Override
    public String toString () {
        return "The account of " + this.name + " has " + this.balance + " dollars.";
    }

    public void deposit (double d) {
        if (d > 0) {
            this.balance += d;
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public double withdraw (double d) {
        if (d < 0 || d > this.balance) {
            this.balance -= 10;
            return 0;
        } else {
            this.balance -= d;
            return d;
        }
    } 
}