package MainMenu.Talismans;

import MainMenu.Deck;
import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_95 extends TalismanA{
    public T1_95(Game gameContext, GameGame gameGameContext) {
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
                for (int i =0; i <gameGame.hand.length;i++){
                    if (gameGame.hand[i] /10==3 || gameGame.hand[i]==350) {
                        game.Money+=(upgraded?9:6);
                    }
                }
            }
        }
    }
}
