// Fig. 4.5: StudentTest.java
// Create and test Student objects.

package ch04.examples.StudentAppV1Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ch04.examples.StudentAppV1.Student;

import org.junit.jupiter.api.Test;

public class StudentTest {

    private final Student student1 = new Student("Jane Green", 93.5);
    private final Student student2 = new Student("John Blue", 72.75);
    private final Student student3 = new Student("Bob Red", 85.75);
    private final Student student4 = new Student("Mary Purple", 63.75);
    private final Student student5 = new Student("Dick Gray", 43.75);

    @Test
    public void getName()
    {
        assertEquals("Jane Green", student1.getName());
        assertEquals("John Blue", student2.getName());
    }

    @Test
    public void letterGrade() {
        assertEquals("A", student1.getLetterGrade());
        assertEquals("B", student3.getLetterGrade());
        assertEquals("C", student2.getLetterGrade());
        assertEquals("D", student4.getLetterGrade());
        assertEquals("F", student5.getLetterGrade());
    }
    
}