package game.utils.commands.base;

import game.layers.GameRuntimeContext;


/**
 *
 *      In essence, a `Command` class is what mutates the game.
 *
 *      Command layer forwards input to the appropriate `Command`
 *      superclass to make necessary change in game state.
 *
 */

public interface Command {
    String getDescription();
    void execute(GameRuntimeContext gsc);
}
