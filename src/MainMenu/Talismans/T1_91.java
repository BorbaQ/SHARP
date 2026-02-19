package MainMenu.Talismans;

import MainMenu.Deck;
import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_91 extends TalismanA{
    public T1_91(Game gameContext, GameGame gameGameContext) {
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
        if (gameGame != null) {
            if (gameGame.isWinning){
                if (gameGame.lastTile/10 ==4 || gameGame.lastTile==450){
                    if (rand.nextBoolean()){
                        power+= 2;
                    }else{
                        power-= 2;
                    }
                }

                gameGame.han+=power;
            }
        }
    }
}
