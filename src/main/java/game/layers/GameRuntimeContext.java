package game.layers;


/**
 *
 *      GameRuntimeContext class acts as a container to Display and Command layers.
 *
 *      This class is
 *          * mutated by Command layer components
 *          * read by Display layer components
 *
 *      This class basically holds the game state and acts as a glue between all components.
 *      The class is intended to be as dumb as possible and contain almost-no business logic inside.
 *
 */


public class GameRuntimeContext {

    public enum Phase {
        WELCOME,
        GAMEPLAY,
        GAMEOVER,
        TERMINATEPROGRAM
    }

    public enum HandMove {
        ROCK,
        PAPER,
        SCISSORS;
    }

    public GameRuntimeContext() {}

    // flags start
    public boolean userEnteredInvalidCommandFlag = false;
    public boolean oneTimeOverlayPrintedFlag = false;
    // flags end

    public Phase currentPhase = Phase.WELCOME; // todo: make it private and administer all traffic via getters/setters
    public int gameResult; // todo: enumerate (message from future: had no time to enumerate this :sademoji: )
    public String gameResultMessage;


    public HandMove playerHandMove;  // set when player makes a move
    public HandMove computerHandMove;  // set when command method gets executed.


    private void _resetPhaseState() {  // internal method. invoked when a phase is reset.
        // further business can be added to this method in case we need to do additional stuff while resetting phase.
        oneTimeOverlayPrintedFlag = false;
    }

    public void setCurrentPhase(Phase desiredPhase) {
        currentPhase = desiredPhase;
        _resetPhaseState();
    }
}
