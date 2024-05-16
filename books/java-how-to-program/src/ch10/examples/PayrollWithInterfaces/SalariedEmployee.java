// Fig. 10.14: SalariedEmployee.java
// SalariedEmployee concrete class extends abastract class Employee.
package ch10.examples.PayrollWithInterfaces;

public class SalariedEmployee extends Employee {

    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, 
        String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        
        validateWeeklySalary(weeklySalary);

        this.weeklySalary = weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        validateWeeklySalary(weeklySalary);

        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    @Override
    public String toString() {
        return String.format("salaried employee: %s%n%s: $%,.2f", 
            super.toString(), "weekly salary", getWeeklySalary());
    }

    private static void validateWeeklySalary(double weeklySalary) {
        if (weeklySalary < 0.0) 
            throw new IllegalArgumentException(
                "weekly salary must be >= 0.0");
    }

    @Override
    public double getPaymentAmount() {
        return getWeeklySalary();
    }

    
}