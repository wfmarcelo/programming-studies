// Fig. 10.6: HourlyEmployee.java
// HourlyEmployee class extends Employee.

package ch10.fig10_4_5_6_7_8_9;

/**
 * HourlyEmployee
 */
public class HourlyEmployee extends Employee {

    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber,
        double wage, double hours) {
        super(firstName, lastName, socialSecurityNumber);

        validateWage(wage);
        validateHours(hours);
        
        this.wage = wage;
        this.hours = hours;
    }

    public void setWage(double wage) {
        validateWage(wage);

        this.wage = wage;
    }

    public double getWage() {
        return wage;
    }

    public void setHours(double hours) {
        validateHours(hours);

        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }

    @Override
    public double earnings() {
        if (getHours() <= 40)
            return getWage() * getHours();
        else
            return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
    }

    @Override
    public String toString() {
        return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f",
        super.toString(), "hourly wage", getWage(),
        "hours worked", getHours());
    }


    private static void validateWage(double wage) {
        if (wage < 0.0) 
            throw new IllegalArgumentException(
                "Hourly wage must be >= 0.0");
    }

    private static void validateHours(double hours) {
        if ((hours < 0.0) || (hours > 168.0)) 
            throw new IllegalArgumentException(
                "Hours worked must be >= 0.0 and <= 168.0");
    }

    
}