// Fig. 10.4: Employee.java
// Employee abstract superclass.
package ch10.examples.PayrollV6;

public abstract class Employee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;

    public Employee(String firstName, String lastName,
        String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    @Override
    public String toString() {
        return String.format("%s %s%nsocial security number: %s", 
            getFirstName(), getLastName(), getSocialSecurityNumber());
    }

    public abstract double earnings();
    
}