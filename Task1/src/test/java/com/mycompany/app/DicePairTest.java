package com.mycompany.app;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DicePairTest {

    private static final int DEFAULT_TIMEOUT = 1000;

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_roll_returnsValueWithinValidRange_2_to_12() {
        DicePair dicePair = new DicePair();
        int actual = dicePair.roll();

        assertTrue("dice pair roll should be between 2 and 12 inclusive", actual >= 2 && actual <= 12);
    }
}