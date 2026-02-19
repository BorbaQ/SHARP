package MainMenu.Talismans;

import MainMenu.Deck;
import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_89 extends TalismanA{
    public T1_89(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    boolean first = false;

    @Override
    public void TakeEffect() throws IOException, FontFormatException {
        if (gameGame != null) {
            if (gameGame.initialization){
                gameGame.locked+=3;
                first = true;
            }
            if (!gameGame.initialization && first){
                power += gameGame.locked/(upgraded? 3:6);
            }
            if (gameGame.isWinning){
                gameGame.han+=power;
            }
        }
    }
}
