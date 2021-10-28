package game.utils.commands;

import game.layers.GameRuntimeContext;
import game.utils.commands.base.BaseSubmitCommand;
import game.utils.commands.base.Command;


/**
 *
 * Invoked when player makes "Paper" move.
 *
 */

public class SubmitPaperCommand extends BaseSubmitCommand implements Command {
    @Override
    public String getDescription() {
        return "submit paper";
    }

    @Override
    public GameRuntimeContext.HandMove getHandMove() {
        return GameRuntimeContext.HandMove.PAPER;
    }
}
