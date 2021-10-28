package game.utils.commands;

import game.layers.GameRuntimeContext;
import game.utils.commands.base.Command;


/**
 *
 * Invoked when player wants to terminate the game.
 *
 *
 */

public class CloseGameCommand implements Command {

    @Override
    public String getDescription() {
        return "close game";
    }

    public void execute(GameRuntimeContext runtimeContext) {
        runtimeContext.setCurrentPhase(GameRuntimeContext.Phase.TERMINATEPROGRAM);
    }
}
