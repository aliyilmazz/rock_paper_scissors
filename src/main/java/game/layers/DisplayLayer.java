package game.layers;

import game.utils.overlays.GameOverOverlay;
import game.utils.overlays.GameplayOverlay;
import game.utils.overlays.WelcomeMenuOverlay;
import game.utils.overlays.base.Overlay;

import java.util.HashMap;
import java.util.Map;


/***
 *
 *      DisplayLayer is responsible from reading the runtime context and rendering the game.
 *
 *      DisplayLayer communicates with following components:
 *          * Overlays: During gameplay, each phase's overlay is responsible from rendering appropriate phase display.
 *          * Command Layer: DisplayLayer asks CommandLayer for phase details and then decides what to render.
 *          * Game Engine (RBS): DisplayLayer gets invoked by Game Engine and delivers output to STDOUT.
 *
 */


// todo: move string constants to a proper place

public class DisplayLayer {

    GameRuntimeContext runtimeContext;
    CommandLayer commandLayer;

    // each phase maps to an `Overlay`. These `Overlay` classes help DisplayLayer render the phase welcoming screen.
    Map<GameRuntimeContext.Phase, Overlay> phaseToOverlayMap;

    public DisplayLayer(GameRuntimeContext runtimeContext, CommandLayer commandLayer) {
        this.runtimeContext = runtimeContext;
        this.commandLayer = commandLayer;

        phaseToOverlayMap = new HashMap<>(){{
           put(GameRuntimeContext.Phase.WELCOME, new WelcomeMenuOverlay(runtimeContext));
           put(GameRuntimeContext.Phase.GAMEPLAY, new GameplayOverlay(runtimeContext));
           put(GameRuntimeContext.Phase.GAMEOVER, new GameOverOverlay(runtimeContext));
        }};
    }


    // in every loop, available commands are shown for better gameplay experience.
    public void printKeyBindsSection(Map<Character, String> keybinds) {

        StringBuilder keyBindsContent = new StringBuilder();

        if (runtimeContext.userEnteredInvalidCommandFlag) {
            keyBindsContent.append("You have entered invalid input!\n");
            runtimeContext.userEnteredInvalidCommandFlag = false;
        }

        String keyBindsBanner = "Available Keybinds:\n";
        keyBindsContent.append(keyBindsBanner);

        keybinds.forEach((keyBindCharacter, commandDescription) -> {
            keyBindsContent.append(
                String.format(
                    """
                    \uD83D\uDC49 Press %s to %s
                    """, keyBindCharacter, commandDescription
                )
            );
        });
        System.out.println(keyBindsContent);
    }


    /**
     *      Overall, the display consists of two main sections:
     *          [1] the overlay provided by phase-specific concrete `Overlay` superclasses
     *          [2] the 'available commands' section which tells user what happens when pressing a key.
     */
   public void getDisplay() {

       if (!commandLayer.isPhasePlayable(runtimeContext.currentPhase)) {
           System.out.println("Bye!");
           System.exit(0);
       }

        var overlay = phaseToOverlayMap.get(runtimeContext.currentPhase);
        var keybinds = commandLayer.
                getKeybindsAndDescriptionsForPhase(runtimeContext.currentPhase);
        overlay.printOverlay();
        printKeyBindsSection(keybinds);
    }
}
