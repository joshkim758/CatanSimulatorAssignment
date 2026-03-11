package com.mycompany.app;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private static final int DEFAULT_TIMEOUT = 1000;
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }



    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_canUpgradeToCity_playersOwnSettlement_returnsTrue_1() {
        board.placeSettlement(0, 0);

        
        assertTrue("player 0 can upgrade their own settlement at node 0", board.canUpgradeToCity(0, 0));
    }


    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_canUpgradeToCity_emptyNode_returnsFalse_2() {
        assertFalse("empty node cannot be upgraded to a city", board.canUpgradeToCity(0, 0));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_canUpgradeToCity_otherPlayersSettlement_returnsFalse_3() {
        board.placeSettlement(1, 0);
        assertFalse("player 0 cannot upgrade player 1's settlement at node 0", board.canUpgradeToCity(0, 0));
    }
}