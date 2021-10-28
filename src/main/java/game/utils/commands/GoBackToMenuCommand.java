package game.utils.commands;

import game.layers.GameRuntimeContext;
import game.utils.commands.base.Command;


/**
 *
 * Invoked when player wants to shift to Welcome phase.
 *
 *
 */

public class GoBackToMenuCommand implements Command {
    public String getDescription() { return "go back to starting menu"; }

    public void execute(GameRuntimeContext runtimeContext) {
        runtimeContext.setCurrentPhase(GameRuntimeContext.Phase.WELCOME);
    }
}
