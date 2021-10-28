package game.layers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LayerTests {

    GameRuntimeContext runtimeContext;

    @Before
    public void setUp() {
        runtimeContext = new GameRuntimeContext();
    }

    @Test
    public void testPhaseResetClearsFlag() {
        // arrange
        runtimeContext.oneTimeOverlayPrintedFlag = true;

        // act
        runtimeContext.setCurrentPhase(GameRuntimeContext.Phase.GAMEOVER);

        // assert
        assertFalse(runtimeContext.oneTimeOverlayPrintedFlag);
    }

    @Test
    public void testCommandLayerPlayablePhase() {
        CommandLayer commandLayer = new CommandLayer(runtimeContext);

        assertTrue(commandLayer.isPhasePlayable(GameRuntimeContext.Phase.WELCOME));
        assertTrue(commandLayer.isPhasePlayable(GameRuntimeContext.Phase.GAMEPLAY));
        assertTrue(commandLayer.isPhasePlayable(GameRuntimeContext.Phase.GAMEOVER));

        assertFalse(commandLayer.isPhasePlayable(GameRuntimeContext.Phase.TERMINATEPROGRAM));
    }
}