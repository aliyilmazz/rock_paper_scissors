package game.utils.commands.base;

import game.layers.GameRuntimeContext;


/**
 *
 *  The `BaseSubmitCommand` contains common invocations for `Submit` classes.
 *  The class consumes CombatUtility methods to mutate the context accordingly.
 *
 */


public abstract class BaseSubmitCommand extends BaseCombatUtility implements Command {

    public abstract GameRuntimeContext.HandMove getHandMove();

    public String getResultMessage(GameRuntimeContext runtimeContext) {
        switch (runtimeContext.gameResult) {
            case 0 -> {
                return "Draw!";
            }
            case 1 -> {
                return String.format("You win! %s beats %s!",
                        runtimeContext.playerHandMove.name(),
                        runtimeContext.computerHandMove.name()
                );

            }
            case 2 -> {
                return String.format("You lose! %s beats %s!",
                        runtimeContext.computerHandMove.name(),
                        runtimeContext.playerHandMove.name()
                );
            }
            default -> {
                return "An unknown error occurred. We had no time to implement auto-bug-report via network feature. " +
                        "Please submit this bug to us via email at ifoundabug@imc.com.";
            }
        }
    }

    public void execute(GameRuntimeContext runtimeContext) {
        runtimeContext.playerHandMove = getHandMove();
        runtimeContext.computerHandMove = generateComputerHandMove();
        runtimeContext.gameResult = compareHandMoves(runtimeContext.playerHandMove, runtimeContext.computerHandMove);
        runtimeContext.gameResultMessage = getResultMessage(runtimeContext);
        runtimeContext.setCurrentPhase(GameRuntimeContext.Phase.GAMEOVER);
    }
}
