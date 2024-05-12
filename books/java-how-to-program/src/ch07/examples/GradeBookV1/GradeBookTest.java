// Fig. 7.15: GradeBookTest.java
// GradeBookTest creates a GradeBook object using an array of grades,
// then invokes method processGrades to analyze them.
package ch07.examples.GradeBookV1;

/**
 * GradeBookTest
 */
public class GradeBookTest {
    public static void main(String[] args) {
        int[] gradesArray = {
            87, 68, 94, 100, 83,
            78, 85, 91, 76, 87
        };

        GradeBook myGradeBook = new GradeBook(
            "CS101 Introduction to Java Programming", gradesArray);
        System.out.printf("Welcome to the grade book for %n%s%n%n",
            myGradeBook.getCourseName());
        myGradeBook.processGrades();
    }
    
}