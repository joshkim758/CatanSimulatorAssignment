package com.mycompany.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BankTest {

    private static final int DEFAULT_TIMEOUT = 1000;
    private Bank bank;
    @Before
    public void setUp() {
        bank = new Bank();
    }
    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_canGive_atExactBoundary19_returnsTrue_1() {
        boolean actual = bank.canGive(Resource.WOOD, 19);
        assertTrue("bank can give 19 WOOD cards at the initial boundary", actual);
    }
    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_canGive_justAboveBoundary20_returnsFalse_2() {
        boolean actual = bank.canGive(Resource.WOOD, 20); //exceeds, should work
        assertFalse("bank cannot give 20 WOOD cards when initialized with 19", actual);
    }
}