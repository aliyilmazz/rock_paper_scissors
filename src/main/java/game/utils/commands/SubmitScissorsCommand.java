package game.utils.commands;

import game.layers.GameRuntimeContext;
import game.utils.commands.base.BaseSubmitCommand;
import game.utils.commands.base.Command;


/**
 *
 * Invoked when player makes "Scissors" move.
 *
 */

public class SubmitScissorsCommand extends BaseSubmitCommand implements Command {

    GameRuntimeContext.HandMove handMove = GameRuntimeContext.HandMove.SCISSORS;

    @Override
    public String getDescription() {
        return "submit scissors";
    }

    @Override
    public GameRuntimeContext.HandMove getHandMove() {
        return GameRuntimeContext.HandMove.SCISSORS;
    }
}
