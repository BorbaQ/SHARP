package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_81 extends TalismanA{
    public T1_81(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    boolean first = false;
    int souls =0;

    @Override
    public void TakeEffect() throws IOException, FontFormatException {
        if (gameGame != null) {
            if (gameGame.initialization) {
                first = true;
                souls =0;
            }
            if (gameGame.isWinning && first) {
                first = false;
                for (int tile : gameGame.hand){
                    for (int soul : Main.mainWindow.game.SoulTiles){
                        if (tile==soul){
                            souls++;
                        }
                    }
                }

                for (int kantile : gameGame.KansArray) {
                    for (int soul : Main.mainWindow.game.SoulTiles) {
                        if (kantile==soul){
                            souls++;souls++;
                            souls++;souls++;
                        }
                    }
                }
                game.Money+=souls*(upgraded?4:2);
            }
        }
    }
}
