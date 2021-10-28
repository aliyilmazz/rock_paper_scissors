package game.utils.commands;

import game.layers.GameRuntimeContext;
import game.utils.commands.base.Command;


/**
 *
 * Invoked when player wants to shift to gameplay phase.
 * Almost same as `PlayAgainCommand`, with only difference being in description.
 *
 */

public class StartGameCommand implements Command {

    @Override
    public String getDescription() {
        return "start game";
    }

    public void execute(GameRuntimeContext runtimeContext) {
        runtimeContext.setCurrentPhase(GameRuntimeContext.Phase.GAMEPLAY);
    }
}
