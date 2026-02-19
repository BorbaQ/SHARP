package MainMenu.Talismans;

import MainMenu.Deck;
import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_93 extends TalismanA{
    public T1_93(Game gameContext, GameGame gameGameContext) {
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
                int num =0;
                for (int i =0; i <gameGame.hand.length-2;i++){
                    if (gameGame.hand[i] /10==3 && gameGame.hand[i+1]==gameGame.hand[i+2] && gameGame.hand[i+1]==gameGame.hand[i]){
                        num++;
                    }
                    if (gameGame.hand[i]==350 && gameGame.hand[i+1]==gameGame.hand[i+2] && gameGame.hand[i+1]==35){
                        num++;
                    }
                }

                game.Money+=num*(upgraded?6:4);
            }
        }
    }
}
