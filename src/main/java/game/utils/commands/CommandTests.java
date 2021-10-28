package game.utils.commands;

import game.layers.GameRuntimeContext;
import org.junit.Before;
import org.junit.Test;

import static game.utils.commands.base.BaseCombatUtility.compareHandMoves;
import static org.junit.Assert.assertEquals;


public class CommandTests {

    GameRuntimeContext runtimeContext;
    int gameResult;

    @Before
    public void setUp() {
        runtimeContext = new GameRuntimeContext();
    }

    @Test
    public void testCompareDraw() {

        gameResult = compareHandMoves(GameRuntimeContext.HandMove.ROCK, GameRuntimeContext.HandMove.ROCK);
        assertEquals(gameResult, 0);

        gameResult = compareHandMoves(GameRuntimeContext.HandMove.PAPER, GameRuntimeContext.HandMove.PAPER);
        assertEquals(gameResult, 0);

        gameResult = compareHandMoves(GameRuntimeContext.HandMove.SCISSORS, GameRuntimeContext.HandMove.SCISSORS);
        assertEquals(gameResult, 0);
    }

    @Test
    public void testCompareVictory() {

        gameResult = compareHandMoves(GameRuntimeContext.HandMove.ROCK, GameRuntimeContext.HandMove.SCISSORS);
        assertEquals(gameResult, 1);

        gameResult = compareHandMoves(GameRuntimeContext.HandMove.PAPER, GameRuntimeContext.HandMove.ROCK);
        assertEquals(gameResult, 1);

        gameResult = compareHandMoves(GameRuntimeContext.HandMove.SCISSORS, GameRuntimeContext.HandMove.PAPER);
        assertEquals(gameResult, 1);
    }

    @Test
    public void testCompareDefeat() {

        gameResult = compareHandMoves(GameRuntimeContext.HandMove.ROCK, GameRuntimeContext.HandMove.PAPER);
        assertEquals(gameResult, 2);

        gameResult = compareHandMoves(GameRuntimeContext.HandMove.PAPER, GameRuntimeContext.HandMove.SCISSORS);
        assertEquals(gameResult, 2);

        gameResult = compareHandMoves(GameRuntimeContext.HandMove.SCISSORS, GameRuntimeContext.HandMove.ROCK);
        assertEquals(gameResult, 2);
    }

    @Test
    public void testCloseGameCommand() {
        new CloseGameCommand().execute(runtimeContext);
        assertEquals(runtimeContext.currentPhase, GameRuntimeContext.Phase.TERMINATEPROGRAM);
    }

    @Test
    public void testGoBackToMenuCommand() {
        new GoBackToMenuCommand().execute(runtimeContext);
        assertEquals(runtimeContext.currentPhase, GameRuntimeContext.Phase.WELCOME);
    }

    @Test
    public void testStartGameCommand() {
        new StartGameCommand().execute(runtimeContext);
        assertEquals(runtimeContext.currentPhase, GameRuntimeContext.Phase.GAMEPLAY);
    }

}