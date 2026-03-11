package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class TileTest {

    private static final int DEFAULT_TIMEOUT = 1000;
    private Tile makeTile(Terrain terrain) {
        return new Tile(0, terrain, 6);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_getResource_forestPartition_returnsWood_1() {
        Tile actual = makeTile(Terrain.FOREST);
        assertEquals("resource for FOREST terrain", Resource.WOOD, actual.getResource());
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_getResource_hillsPartition_returnsBrick_2() {
        Tile actual = makeTile(Terrain.HILLS);
        assertEquals("resource for HILLS terrain", Resource.BRICK, actual.getResource());
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_getResource_fieldsPartition_returnsWheat_3() {
        Tile actual = makeTile(Terrain.FIELDS);
        assertEquals("resource for FIELDS terrain", Resource.WHEAT, actual.getResource());
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_getResource_pasturePartition_returnsSheep_4() {
        Tile actual = makeTile(Terrain.PASTURE);
        assertEquals("resource for PASTURE terrain", Resource.SHEEP, actual.getResource());
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_getResource_mountainsPartition_returnsOre_5() {
        Tile actual = makeTile(Terrain.MOUNTAINS);
        assertEquals("resource for MOUNTAINS terrain", Resource.ORE, actual.getResource());
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_getResource_desertPartition_returnsNull_6() {
        Tile actual = makeTile(Terrain.DESERT);
        assertNull("resource for DESERT terrain", actual.getResource());
    }
}