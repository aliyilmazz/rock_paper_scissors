package game.utils.commands;

import game.layers.GameRuntimeContext;
import game.utils.commands.base.BaseSubmitCommand;
import game.utils.commands.base.Command;


/**
 *
 * Invoked when player makes "Rock" move.
 *
 */

public class SubmitRockCommand extends BaseSubmitCommand implements Command {

    @Override
    public String getDescription() {
        return "submit rock";
    }

    @Override
    public GameRuntimeContext.HandMove getHandMove() {
        return GameRuntimeContext.HandMove.ROCK;
    }
}
