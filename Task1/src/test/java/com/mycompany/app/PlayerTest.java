package com.mycompany.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

    private static final int DEFAULT_TIMEOUT = 1000;


    private Player player;

    @Before
    public void setUp() {
        player = new Player(0);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_hasResources_withExactRequiredCards_returnsTrue_1() {
        player.addResource(Resource.WOOD, 1);
        player.addResource(Resource.BRICK, 1);

        Map<Resource, Integer> cost = Map.of(Resource.WOOD, 1,Resource.BRICK, 1);
        assertTrue("player has required wood and brick (exactly)", player.hasResources(cost));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_hasResources_missingOneRequiredCard_returnsFalse_2() {
        player.addResource(Resource.WOOD, 1);
        player.addResource(Resource.BRICK, 0);
        Map<Resource, Integer> cost = Map.of(Resource.WOOD, 1, Resource.BRICK, 1);
        assertFalse("player is missing one required brick", player.hasResources(cost));
    }


        @Test(timeout = DEFAULT_TIMEOUT)
    public void test_totalCards_forNewPlayer_returnsZero_3() {
        assertEquals("total cards for a new player", 0, player.totalCards());
        
    }


    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_totalCards_withMultipleResources_returnsSum_4() {
        player.addResource(Resource.WOOD, 2);
        player.addResource(Resource.BRICK, 3);
        player.addResource(Resource.ORE, 1);
        assertEquals("total cards after adding multiple resources", 6, player.totalCards());
    }
}