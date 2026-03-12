
package com.mycompany.app;

import java.util.Random;

/**
 * demonstrates assignment 2 gameplay by creating and connecting together
 * all major game components, then starting a playable game session
 *
 * this class acts as the entry point for the demonstration run.
 */
public class Demonstrator {
    public static void main(String[] args) {

        //load configuration file path from the command line if it was provided
        //otherwise, fall back to the default config file location
        String configPath = args.length > 0 ? args[0] : "Task1/src/main/java/com/mycompany/app/config.txt";
        GameConfig config = GameConfig.load(configPath);

        //create the core domain objects required by the game
        Board board = new Board();
        Bank bank = new Bank();
        TurnManager turnManager = new TurnManager();

        //use a pair of regular dice for rolling during the game
        Dice dice = new DicePair();


        //create the four players required for the game
        //p0 is the human player; the others are machine agents
        Player[] players = new Player[] {
                new Player(0, PlayerColor.RED),
                new Player(1, PlayerColor.BLUE),
                new Player(2, PlayerColor.ORANGE),
                new Player(3, PlayerColor.WHITE)
        };

        //set up the command line user interface and command parser
        //this is used by the human player.
        CommandLineUI ui = new ConsoleUI();
        CommandParser parser = new CommandParser();
        //assign one human controller and three random agent controllers
        PlayerController[] controllers = new PlayerController[] {new HumanController(parser, ui), new RandomAgentController(), new RandomAgentController(), new RandomAgentController()};

        //ceate the JSON writer used to export the current game state
        //for the external visualizer
        GameStateWriter writer = new JsonGameStateWriter("2aa4-2026-base/assignments/visualize/state.json");
        //enable step forward mode so the human can control progression
        //between machine agent turns       
        StepController stepper = new StepController(ui, true);

        //construct the game by using all required components
        Game game = new Game(
                board,
                bank,
                turnManager,
                dice,
                players,
                controllers,
                writer,
                stepper,
                new Random()
        );

        //write an initial empty game state so the visualizer starts
        game.writeGameState();

        System.out.println("Starting  demonstration.");
        System.out.println("Human player is P0 (RED). Use the following commands: Roll, List, Build, Go");

        //run the game for the number of turns showed in the confid file
        game.run(config.turns());
        System.out.println("Simulation ended.");
    }
}