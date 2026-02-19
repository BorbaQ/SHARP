package MainMenu.Talismans;

import MainMenu.Deck;
import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_85 extends TalismanA{
    public T1_85(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() throws IOException, FontFormatException {
        if (gameGame != null) {
            if (gameGame.isWinning){
                for(int tile : gameGame.hand){
                    if (tile%10==1 || tile%10==9){
                        power+= (upgraded?2:1);
                    }
                }
                gameGame.han+=power;
            }
        }
    }
}
