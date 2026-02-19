package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_53 extends TalismanA{
    public T1_53(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    Random rand = new Random();
    @Override
    public void TakeEffect() throws IOException, FontFormatException {
        if (gameGame!=null) {
            if (!gameGame.isWinning) {
                if (gameGame.wallIndex>9){
                    power++;
                }
            }
            if (gameGame.isWinning){
                if (upgraded){
                    gameGame.han += power * (gameGame.han / 5);
                }else {
                    gameGame.han += power * (gameGame.han / 10);
                }
            }

        }
    }
}
