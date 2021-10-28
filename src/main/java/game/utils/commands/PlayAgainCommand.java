package game.utils.commands;

import game.layers.GameRuntimeContext;
import game.utils.commands.base.Command;


/**
 *
 * Invoked when player wants to shift to gameplay phase.
 * Almost same as `StartGameCommand`, with only difference being in description.
 *
 */

public class PlayAgainCommand implements Command {
    public String getDescription() { return "play again"; }

    public void execute(GameRuntimeContext runtimeContext) {
        runtimeContext.setCurrentPhase(GameRuntimeContext.Phase.GAMEPLAY);
    }
}
