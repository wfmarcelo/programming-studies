package ch03.fig3_5_6;

// Fig. 3.5: Account.java
// Account class with a constructor that initializes the name.

public class Account {
    private String name;

    public Account(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
