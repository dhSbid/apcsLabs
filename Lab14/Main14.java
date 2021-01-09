import java.util.Scanner;

public class Main14 {
    public static void main (String[] args) {
        BankAccount a = new BankAccount(50, "Al");
        BankAccount b = new BankAccount(25, "Bob");
        BankAccount c = new BankAccount(44, "Carl");

        printBankAccount(a);
        printBankAccount(b);
        printBankAccount(c);

        print("using the toString method and checking the numbers");
        print(a.toString());
        print("a has the account number " + a.getAccountNumber());
        print("there are a total of " + BankAccount.getNumberOfAccountsCreated()+ " accounts made");

        print("\n\nTesting bonuses: ");
        //testBonus();
        bankApp();
    }

    public static void print (String s) {
        System.out.println(s);
    }

    public static void printBankAccount (BankAccount ba) {
        print(ba.getName() + " has $" + ba.getBalance() + " in their account.");
    }

    public static void testBonus () {
        //will make account 97, 197...497 instead of what was expected due to creating 3 accounts before this in main
        BankAccount[] accounts = new BankAccount[500];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new BankAccount(i + 1, "Acct" + (i + 1));
            print(accounts[i].toString());
        }
    }

    public static void bankApp () {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        BankAccount[] accts = new BankAccount[100];
        int on = 0;

        do {
            print("\n\n1. Create a new account\n2. View all accounts \n3. Quit \nEnter your selection: ");
            input = scan.nextInt();

            if (input == 1) {
                scan.nextLine();
                print("\nName: ");
                String name = scan.nextLine();
                print("Balance: ");
                double bal = scan.nextDouble();

                accts[on] = new BankAccount(bal, name);
                on++;

            } else if (input == 2) {
                if (on != 0) {
                    for (int i = 0; i < on; i++) {
                        print(accts[i].toString());
                    } 
                } else {
                    print("\nThere are no bank accounts yet.");
                }
            }

        }
        while (input != 3);
    }
}