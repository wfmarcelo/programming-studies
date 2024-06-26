package ch05.fig5_11_12.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ch05.fig5_11_12.AutoPolicy;


public class AutoPolicyTest {

    @Test
    public void isNoFaultState()
    {
        AutoPolicy policy1 = 
            new AutoPolicy(11111111, "Toyota Camry", "NJ");
        AutoPolicy policy2 = 
            new AutoPolicy(22222222, "Ford Fusion", "ME");

        assertTrue(policy1.isNoFaultState());
        assertFalse(policy2.isNoFaultState());
    }
    
}
