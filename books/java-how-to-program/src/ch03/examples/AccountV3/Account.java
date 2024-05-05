package ch03.examples.AccountV3;

// Fig. 3.8: Account.java
// Account class with a double instance variable balance and a constructor
// and deposit method that perform validation.

public class Account {
    private String name;
    private double balance;

    public Account(String name, double balance) {
        this.name = name;

        if (balance > 0.0)
            this.balance = balance;
    }

    public void deposit(double depositAmount) {
        if (depositAmount > 0.0)
            balance += depositAmount;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}
