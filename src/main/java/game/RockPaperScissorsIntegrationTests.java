package game;

import game.layers.GameRuntimeContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import org.junit.Before;
//import org.junit.Test;


public class RockPaperScissorsIntegrationTests {

    RockPaperScissors rps;

    @BeforeEach
    public void setUp() {
        rps = new RockPaperScissors();
    }

    @Test
    public void testSanityCheckAfterBootstrap() {
        assertNotNull(rps.gameRuntimeContext);
        assertNotNull(rps.commandLayer);
        assertNotNull(rps.displayLayer);
        assertEquals(rps.gameRuntimeContext.currentPhase, GameRuntimeContext.Phase.WELCOME);
    }

    @Test
    public void testInvalidInputIsIgnoredByCommandLayer() {
        assertEquals(rps.gameRuntimeContext.currentPhase, GameRuntimeContext.Phase.WELCOME);
        rps.commandLayer.processInput("some_invalid_input");  // arrange
        boolean esitMi = rps.gameRuntimeContext.currentPhase.equals(GameRuntimeContext.Phase.GAMEPLAY);
        assertEquals(rps.gameRuntimeContext.currentPhase, GameRuntimeContext.Phase.GAMEPLAY);
        assertEquals(2,3);
    }

    @Test
    public void testSuccessfulShiftIntoGameplayPhase() {
        rps.commandLayer.processInput("x");  // arrange
        assertEquals(rps.gameRuntimeContext.currentPhase, GameRuntimeContext.Phase.GAMEPLAY);
    }

    @Test
    public void testSuccessfulShiftIntoTerminationPhase() {
        rps.commandLayer.processInput("Q");  // arrange
        assertEquals(rps.gameRuntimeContext.currentPhase, GameRuntimeContext.Phase.TERMINATEPROGRAM);
    }

}
