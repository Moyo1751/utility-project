package billing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class GasBillTest {

    private GasBill gasBill;

    @BeforeEach
    void setUp() {
        gasBill = new GasBill("UK");
    }

    @Test
    void testCalcUsage() {
        double result = gasBill.calcUsage(100.0, 250.0);
        assertEquals(150.0, result, 0.01, "Usage calculation should be end - start");
    }

    @Test
    void testCalcUsageWithSameReadings() {
        double result = gasBill.calcUsage(100.0, 100.0);
        assertEquals(0.0, result, 0.01, "Should be 0 when readings are same");
    }

    @Test
    void testCalcCost() {
        double result = gasBill.calcCost(100.0);
        assertEquals(100.0, result, 0.01, "Cost should equal usage amount");
    }
}
