package game.utils.commands.base;

import game.layers.GameRuntimeContext;

import java.util.Random;


/**
 *
 *  This class includes common core business for all combat classes (`SubmitPaper` etc)
 *
 *  The class is responsible from
 *      * generating computer move,
 *      * making comparison and determining winner of game.
 *
 *  The utility functions are consumed by our abstract `BaseSubmitCommand` class.
 *
 */


public class BaseCombatUtility {


    public GameRuntimeContext.HandMove generateComputerHandMove() {
        // the computer behavior can be enhanced, hence I chose to wrap it under a method
        return GameRuntimeContext.HandMove.values()[new Random().nextInt(GameRuntimeContext.HandMove.values().length)];
    }

    public static int compareHandMoves(GameRuntimeContext.HandMove playerHandMove, GameRuntimeContext.HandMove computerHandMove) {

        // definitely open to refactoring. currently satisfactory for 3 moves.
        // we should refactor if we foresee frequent additions of new moves into the game.
        // in the long term, the nested if's will be very hard to read.

        // naive suggestion:
        // we can shift into a class approach where each HandMove defines its weak and strong opponents.

        if (playerHandMove == computerHandMove) return 0;

        if (playerHandMove == GameRuntimeContext.HandMove.ROCK) {
            if (computerHandMove == GameRuntimeContext.HandMove.SCISSORS) {
                return 1;
            }
            if (computerHandMove == GameRuntimeContext.HandMove.PAPER) {
                return 2;
            }
        }

        if (playerHandMove == GameRuntimeContext.HandMove.PAPER) {
            if (computerHandMove == GameRuntimeContext.HandMove.ROCK) {
                return 1;
            }
            if (computerHandMove == GameRuntimeContext.HandMove.SCISSORS) {
                return 2;
            }
        }

        if (playerHandMove == GameRuntimeContext.HandMove.SCISSORS) {
            if (computerHandMove == GameRuntimeContext.HandMove.PAPER) {
                return 1;
            }
            if (computerHandMove == GameRuntimeContext.HandMove.ROCK) {
                return 2;
            }
        }
        return -1;  // unknown error
    }
}