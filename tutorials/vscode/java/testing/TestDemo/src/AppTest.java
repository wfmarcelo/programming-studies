import static org.junit.jupiter.api.Assertions.assertEquals;

import example.util.Calculator;

import org.junit.jupiter.api.Test;

public class AppTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void addition() {
        assertEquals(2, calculator.add(1, 1));
    }
    
}
