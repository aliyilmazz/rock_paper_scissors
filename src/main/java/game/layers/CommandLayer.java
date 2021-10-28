package game.layers;

import game.utils.commands.*;
import game.utils.commands.base.Command;

import java.util.HashMap;
import java.util.Map;


/**

CommandLayer is where the business takes place.

Main responsibility of command layers are:

 * declare game keybinds.
 * serve as an API to displayLayer:
    * ability to interpret whether current state is playable or not. (`isPhasePlayable`)
    * serve what keybinds are available for given state (`getKeybindsAndDescriptionsForPhase`)
 * serve as an API to game engine (RPS):
    * ability to forward user input to appropriate `Command` class.

**/

public class CommandLayer {

    GameRuntimeContext runtimeContext;
    Map<GameRuntimeContext.Phase, Map<Character, Command>> availableCommandsForAllPhases = new HashMap<>(){{
        put(GameRuntimeContext.Phase.WELCOME, new HashMap<>(){{
            put('x', new StartGameCommand());
            put('Q', new CloseGameCommand());
        }});
        put(GameRuntimeContext.Phase.GAMEPLAY, new HashMap<>(){{
            put('r', new SubmitRockCommand());
            put('p', new SubmitPaperCommand());
            put('s', new SubmitScissorsCommand());
            put('X', new GoBackToMenuCommand());
            put('Q', new CloseGameCommand());
        }});
        put(GameRuntimeContext.Phase.GAMEOVER, new HashMap<>(){{
            put('q', new GoBackToMenuCommand());
            put('x', new PlayAgainCommand());
            put('Q', new CloseGameCommand());
        }});
    }};

    public CommandLayer(GameRuntimeContext runtimeContext) {
        this.runtimeContext = runtimeContext;
    }

    // API for displayLayer to infer if current Phase is playable or not.
    public boolean isPhasePlayable(GameRuntimeContext.Phase currentPhase) {
        // open for refactoring. currently it just checks if given phase is registered in our keybind map.
        return (availableCommandsForAllPhases.containsKey(currentPhase));
    }

    // API for displayLayer to display available commands at current phase.
    public Map<Character, String> getKeybindsAndDescriptionsForPhase(GameRuntimeContext.Phase phase) {
        Map<Character, String> keybindsAndDescriptionsForPhase = new HashMap<>();
        Map<Character, Command> availableCommands = this.availableCommandsForAllPhases.get(phase);

        availableCommands.forEach((keyBind, command) -> {
            keybindsAndDescriptionsForPhase.put(keyBind, command.getDescription());
        });

        return keybindsAndDescriptionsForPhase;
    }

    // API for Game Engine to process input and mutate game state.
    public void processInput(String userInput) {
        if (userInput.length()>1) {
            // early return #1: currently the program do not support multiple-character inputs.
            // action: set the flag, so that displayLayer will use this flag and ask user for legit input.
            this.runtimeContext.userEnteredInvalidCommandFlag = true;
            return;
        }

        char c = userInput.charAt(0);

        var availableCommandsForCurrentPhase =
                availableCommandsForAllPhases.get(runtimeContext.currentPhase);

        if (!availableCommandsForCurrentPhase.containsKey(c)) {
            // early return #2: the input is not recognized
            // action: set the flag, so that displayLayer will use this flag and ask user for legit input.
            this.runtimeContext.userEnteredInvalidCommandFlag = true;
            return;
        }

        Command command = availableCommandsForCurrentPhase.get(c);  // summon proper command for given input
        command.execute(this.runtimeContext);  // let command do execution and mutate runtime context
    }


}
