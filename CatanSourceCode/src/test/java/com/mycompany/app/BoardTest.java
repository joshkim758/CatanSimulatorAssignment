package com.mycompany.app;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

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

    @Test
    public void test_canPlaceSettlement_setup_adjacentOccupiedNode_returnsFalse() {
        Board board = new Board();
        board.placeSettlement(1, 14);
        assertFalse(board.canPlaceSettlement(0, 13, Phase.SETUP));
    }


    //extra tests after modification
    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_getEdgeBetween_zeroAndOne_existsInInternalBoardModel_1() {
        assertNotNull("edge (0,1) should exist in the board model", board.getEdgeBetween(0, 1));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_getEdgeBetween_threeAndFour_existsInInternalBoardModel_2() {
        assertNotNull("edge (3,4) should exist in the board model", board.getEdgeBetween(3, 4));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_canPlaceRoad_requiresConnection_notArbitraryEdge_3() {
        Edge edge01 = board.getEdgeBetween(0, 1);
        Edge edge34 = board.getEdgeBetween(3, 4);
        board.placeSettlement(0, 0);

        assertTrue("player 0 should be able to place road on edge (0,1) from settlement at node 0", board.canPlaceRoad(0, edge01.getId()));


        assertFalse("player 0 should not be able to place unrelated road on edge (3,4) without connection", board.canPlaceRoad(0, edge34.getId()));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_canPlaceRoad_afterSettlementAtThree_edgeThreeFourBecomesLegal_4() {
        Edge edge34 = board.getEdgeBetween(3, 4);

        board.placeSettlement(0, 3);
        assertTrue("player 0 should be able to place road on edge (3,4) after placing settlement at node 3", board.canPlaceRoad(0, edge34.getId()));
    }

    
    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_canPlaceSettlement_setup_rejectsAdjacentOccupiedNode_5() {
        board.placeSettlement(1, 14);
        assertFalse("setup settlement should be illegal on adjacent occupied node", board.canPlaceSettlement(0, 13, Phase.SETUP));
    }


    
}