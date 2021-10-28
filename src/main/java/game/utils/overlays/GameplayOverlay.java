package game.utils.overlays;

import game.layers.GameRuntimeContext;
import game.utils.overlays.base.Overlay;


public class GameplayOverlay extends Overlay {

    public static final String gameplayOverlayAsciiArtTemplate =
"""
██      ██████   █████  ███    ███ ███████     ████████ ██ ███    ███ ███████     ██    
██     ██       ██   ██ ████  ████ ██             ██    ██ ████  ████ ██          ██    
██     ██   ███ ███████ ██ ████ ██ █████          ██    ██ ██ ████ ██ █████       ██    
       ██    ██ ██   ██ ██  ██  ██ ██             ██    ██ ██  ██  ██ ██                
██      ██████  ██   ██ ██      ██ ███████        ██    ██ ██      ██ ███████     ██
""";


    public GameplayOverlay(GameRuntimeContext runtimeContext) {
        super(runtimeContext);
    }

    @Override
    public void _printOverlay() {
        System.out.println(ANSI_CYAN + gameplayOverlayAsciiArtTemplate + ANSI_RESET);
    }

}
