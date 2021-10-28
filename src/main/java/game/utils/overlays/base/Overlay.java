package game.utils.overlays.base;


import game.layers.GameRuntimeContext;

abstract public class Overlay {

    // basic overlay utilities that concrete `*Overlay` classes use
    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_BLACK = "\u001B[30m";
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_GREEN = "\u001B[32m";
    protected static final String ANSI_YELLOW = "\u001B[33m";
    protected static final String ANSI_BLUE = "\u001B[34m";
    protected static final String ANSI_PURPLE = "\u001B[35m";
    protected static final String ANSI_CYAN = "\u001B[36m";
    protected static final String ANSI_WHITE = "\u001B[37m";

    protected GameRuntimeContext runtimeContext;
    public Overlay(GameRuntimeContext runtimeContext) {
        this.runtimeContext = runtimeContext;
    }

    protected abstract void _printOverlay();

    public void printOverlay() {
        // this function is called in every loop during a phase.
        // for all concrete overlay classes, default behavior is to print overlay *only once* in a phase.
        // if we want an overlay to print its overlay every time screen is reloaded, we can surely override this method.
        if (!runtimeContext.oneTimeOverlayPrintedFlag) {
            _printOverlay();
            runtimeContext.oneTimeOverlayPrintedFlag = true;
        }
    };
}
