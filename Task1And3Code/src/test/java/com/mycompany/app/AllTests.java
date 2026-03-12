package com.mycompany.app;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    DicePairTest.class,
    TileTest.class,
    BankTest.class,
    TurnManagerTest.class,
    PlayerTest.class,
    BoardTest.class
})
public class AllTests {
}