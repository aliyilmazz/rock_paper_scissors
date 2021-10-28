package game;

import game.layers.CommandLayer;
import game.layers.DisplayLayer;
import game.layers.GameRuntimeContext;

import java.util.Scanner;


/**
 *
 *      RPS class is the game engine.
 *
 *      This game engine
 *          [1] owns game loop
 *          [2] instantiates and communicates with three main components of our system:
 *          * command layer (business layer): responsible from processing user input and mutating the game state.
 *          * display layer: responsible from creating the display.
 *          * runtime context: the store which holds game's state.
 *                             this is a container class which we intend to put almost-no logic inside.
 *
 **/

public class RockPaperScissors {
    GameRuntimeContext gameRuntimeContext;
    DisplayLayer displayLayer;
    CommandLayer commandLayer;

    public RockPaperScissors() {
        gameRuntimeContext = new GameRuntimeContext();
        commandLayer = new CommandLayer(gameRuntimeContext);
        displayLayer = new DisplayLayer(gameRuntimeContext, commandLayer);
    }

    void display() {
        displayLayer.getDisplay();
    }

    void awaitAndProcessUserInput() {
        // if multiple-character inputs become a requirement, we can scale inputs to words. currently works with chars.
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();
        commandLayer.processInput(userInput);
    }

    public void execute() {
        // main loop of game
        while (true) {
            display();
            awaitAndProcessUserInput();
        }
    }
}
