// Fig. 10.8: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class extends CommissionEmployee.

package ch10.fig10_4_5_6_7_8_9;

/**
 * BasePlusCommissionEmployee
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;
    
    public BasePlusCommissionEmployee(String firstName, String lastName, 
        String socialSecurityNumber, double grossSales,
        double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        
        validateBaseSalary(baseSalary);

        this.baseSalary = baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        validateBaseSalary(baseSalary);

        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    @Override
    public double earnings() {
        return getBaseSalary() + super.earnings();
    }

    @Override
    public String toString() {
        return String.format("%s %s; %s: $%,.2f", 
            "base-salaried", super.toString(),
            "base salary", getBaseSalary());
    }

    private static void validateBaseSalary(double baseSalary) {
        if (baseSalary < 0.0) {
            throw new IllegalArgumentException(
                "Base salary must be >= 0.0");
        }
    }

    
}