package com.mycompany.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class CommandParserTest {

    private static final int DEFAULT_TIMEOUT = 1000;
    private CommandParser parser;

    @Before
    public void setUp() {
        parser = new CommandParser();
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_parse_roll_caseInsensitive_returnsRollCommand_1() {
        HumanCommand command = parser.parse("   RoLl   ");

        assertTrue("parser should return RollCommand for 'roll'", command instanceof RollCommand);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_parse_go_returnsGoCommand_2() {
        HumanCommand command = parser.parse("go");
        assertTrue("parser should return GoCommand for 'go'", command instanceof GoCommand);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_parse_list_returnsListCommand_3() {
        HumanCommand command = parser.parse("LIST");

        assertTrue("parser should return ListCommand for 'list'", command instanceof ListCommand);
    }



    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_parse_buildSettlement_withOptionalBracketsAndSpaces_returnsBuildSettlementCommand_4() {
        HumanCommand command = parser.parse(" build settlement [  13 ] ");
        assertTrue("parser should return BuildSettlementCommand for settlement input", command instanceof BuildSettlementCommand);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_parse_buildCity_returnsBuildCityCommand_5() {
        HumanCommand command = parser.parse("build city 24");

        assertTrue("parser should return BuildCityCommand for city input", command instanceof BuildCityCommand);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_parse_buildRoad_withBracketsCommaAndSpaces_returnsBuildRoadCommand_6() {
        HumanCommand command = parser.parse(" build road [ 3 , 4 ] ");
        assertTrue("parser should return BuildRoadCommand for road input", command instanceof BuildRoadCommand);
    }



    @Test(timeout = DEFAULT_TIMEOUT)
    public void test_parse_invalidCommand_throwsIllegalArgumentException_7() {
        try {
            parser.parse("build castle 99");
            fail("invalid command should throw IllegalArgumentException");
        } 
        catch (IllegalArgumentException expected) {
            //pass
        }
    }
}