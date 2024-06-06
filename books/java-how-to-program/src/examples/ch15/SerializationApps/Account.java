// Fig. 15.9: Account.java
// Serializable Account class for storing records as objects.
package ch15.SerializationApps;

import java.io.Serializable;

public record Account(
    int account, String firstName, 
    String lastName, double balance) implements Serializable {

    public Account() {
        this(0, "", "", 0.0);
    }
    
}
