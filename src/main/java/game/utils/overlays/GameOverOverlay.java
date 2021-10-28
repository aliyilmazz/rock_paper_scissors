package game.utils.overlays;

import game.layers.GameRuntimeContext;
import game.utils.overlays.base.Overlay;

import java.util.concurrent.TimeUnit;


public class GameOverOverlay extends Overlay {

    public static final String youWinAsciiArtTemplate =
        """
        ██╗   ██╗ ██████╗ ██╗   ██╗    ██╗    ██╗██╗███╗   ██╗    ██╗
        ╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║    ██║██║████╗  ██║    ██║
         ╚████╔╝ ██║   ██║██║   ██║    ██║ █╗ ██║██║██╔██╗ ██║    ██║
          ╚██╔╝  ██║   ██║██║   ██║    ██║███╗██║██║██║╚██╗██║    ╚═╝
           ██║   ╚██████╔╝╚██████╔╝    ╚███╔███╔╝██║██║ ╚████║    ██╗
           ╚═╝    ╚═════╝  ╚═════╝      ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝    ╚═╝
        """;

    public static final String drawAsciiArtTemplate =
        """
        ██████╗ ██████╗  █████╗ ██╗    ██╗    ██╗
        ██╔══██╗██╔══██╗██╔══██╗██║    ██║    ██║
        ██║  ██║██████╔╝███████║██║ █╗ ██║    ██║
        ██║  ██║██╔══██╗██╔══██║██║███╗██║    ╚═╝
        ██████╔╝██║  ██║██║  ██║╚███╔███╔╝    ██╗
        ╚═════╝ ╚═╝  ╚═╝╚═╝  ╚═╝ ╚══╝╚══╝     ╚═╝
        """;

    public static final String youLoseAsciiArtTemplate =
        """
        ██╗   ██╗ ██████╗ ██╗   ██╗    ██╗      ██████╗ ███████╗███████╗        ██╗
        ╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║     ██╔═══██╗██╔════╝██╔════╝    ██╗██╔╝
         ╚████╔╝ ██║   ██║██║   ██║    ██║     ██║   ██║███████╗█████╗      ╚═╝██║
          ╚██╔╝  ██║   ██║██║   ██║    ██║     ██║   ██║╚════██║██╔══╝      ██╗██║
           ██║   ╚██████╔╝╚██████╔╝    ███████╗╚██████╔╝███████║███████╗    ╚═╝╚██╗
           ╚═╝    ╚═════╝  ╚═════╝     ╚══════╝ ╚═════╝ ╚══════╝╚══════╝        ╚═╝
        """;



    public GameOverOverlay(GameRuntimeContext runtimeContext) {
        super(runtimeContext);
    }

    public void _printOverlay() {

        System.out.println("✱ You drew " + runtimeContext.playerHandMove.name() + ".");
        System.out.print("✱ The computer drew... wait for it... ");

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print(runtimeContext.computerHandMove.name() + "!\n\n");

        switch (runtimeContext.gameResult) {
            case 0 -> {
                System.out.println(ANSI_YELLOW + drawAsciiArtTemplate + ANSI_RESET);
            }
            case 1 -> {
                System.out.println(ANSI_GREEN + youWinAsciiArtTemplate + ANSI_RESET);
            }
            case 2 -> {
                System.out.println(ANSI_RED + youLoseAsciiArtTemplate + ANSI_RESET);
            }
            default -> { /* unreachable state */ }
        }
        System.out.println(this.runtimeContext.gameResultMessage);
        System.out.println("Want to play again?\n");
    }
}
