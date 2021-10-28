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
        rps.commandLayer.processInput("some_invalid_input");  // game should ask user to retry input
        assertEquals(rps.gameRuntimeContext.currentPhase, GameRuntimeContext.Phase.WELCOME);
    }

    @Test
    public void testSuccessfulShiftIntoGameplayPhase() {
        assertEquals(rps.gameRuntimeContext.currentPhase, GameRuntimeContext.Phase.WELCOME);
        rps.commandLayer.processInput("x");  // head into gameplay phase
        assertEquals(rps.gameRuntimeContext.currentPhase, GameRuntimeContext.Phase.GAMEPLAY);
    }

    @Test
    public void testSuccessfulShiftIntoTerminationPhase() {
        assertEquals(rps.gameRuntimeContext.currentPhase, GameRuntimeContext.Phase.WELCOME);
        rps.commandLayer.processInput("Q");  // head into termination phase
        assertEquals(rps.gameRuntimeContext.currentPhase, GameRuntimeContext.Phase.TERMINATEPROGRAM);
    }

}
