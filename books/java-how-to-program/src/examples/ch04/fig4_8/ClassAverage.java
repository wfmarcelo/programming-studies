// Fig. 4.8: ClassAverage.java
// Solving the class-average problem using counter-controlled repetition.
package ch04.fig4_8;

import java.util.Scanner;

/**
 * ClassAverage
 */
public class ClassAverage {
    private static final int SIZE = 10;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int total = 0;
        int gradeCounter = 1;

        while (gradeCounter <= SIZE) {
            System.out.print("Enter grade: ");
            int grade = input.nextInt();

            total = total + grade;
            gradeCounter = gradeCounter + 1;
        }

        int average = total / SIZE;

        System.out.printf("%nTotal of all grades is %d%n", total);
        System.out.printf("Class average is %d%n", average);

        input.close();
    }
    
}