package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TurnManagerTest {

    private static final int DEFAULT_TIMEOUT = 1000;



    private TurnManager turnManager;

    @Before
    public void setUp() {
        turnManager = new TurnManager();
    }
    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_nextTurn_fromPlayer0_advancesToPlayer1_1() {
        turnManager.nextTurn(4);
        assertEquals("current player after one turn from player 0",1, turnManager.currentPlayerIndex());
    }
    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_nextTurn_fromLastPlayer_wrapsToPlayer0_2() {
        turnManager.nextTurn(4); //0 to 1
        turnManager.nextTurn(4); //1 to 2
        turnManager.nextTurn(4); //2 to 3
        turnManager.nextTurn(4); //3 to 0


        assertEquals("current player after wrapping from player 3",0, turnManager.currentPlayerIndex());
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_nextTurn_withOnePlayer_staysAtPlayer0_3() {
        turnManager.nextTurn(1);
        assertEquals("current player when there is only one player",0, turnManager.currentPlayerIndex());
    }
}