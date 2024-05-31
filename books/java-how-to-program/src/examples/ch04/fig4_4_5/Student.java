// Fig. 4.4: Student.java
// Student class that stores a student name and average.
package ch04.fig4_4_5;

public class Student {
    private String name;
    private double average;

    public Student(String name, double average) {
        this.name = name;

        if (average > 0.0)
            if (average <= 100.0)
                this.average = average;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAverage(double average) {
        if (average > 0.0)
            if (average <= 100.0)
                this.average = average;
    }

    public String getName()
    {
        return name;
    }

    public double getAverage()
    {
        return average;
    }

    public String getLetterGrade()
    {
        String letterGrade = "";
        
        if (average >= 90.0)
            letterGrade = "A";
        else if (average >= 80)
            letterGrade = "B";
        else if (average >= 70)
            letterGrade = "C";
        else if (average >= 60)
            letterGrade = "D";
        else
            letterGrade = "F";

        return letterGrade;
    }
    
}