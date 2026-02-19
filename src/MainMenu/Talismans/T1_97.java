package MainMenu.Talismans;

import MainMenu.Deck;
import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_97 extends TalismanA{
    public T1_97(Game gameContext, GameGame gameGameContext) {
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
            if (!gameGame.isWinning && !gameGame.initialization){
                boolean red = false;
                boolean white = false;
                boolean green = false;
                for (int i =0; i <gameGame.hand.length-2;i++){
                    if (gameGame.hand[i] == gameGame.hand[i+1] && gameGame.hand[i] == gameGame.hand[i+2] && gameGame.hand[i] == 17){
                        green = true;
                    }
                    if (gameGame.hand[i] == gameGame.hand[i+1] && gameGame.hand[i] == gameGame.hand[i+2] && gameGame.hand[i] == 16){
                        white = true;
                    }
                    if (gameGame.hand[i] == gameGame.hand[i+1] && gameGame.hand[i] == gameGame.hand[i+2] && gameGame.hand[i] == 15){
                        red = true;
                    }
                }
                if (gameGame.lastTile/10==1){
                    gameGame.canWin = true;
                    gameGame.forecedWin = true;
                }
                if (gameGame.lastTile/10==2 && upgraded){
                    gameGame.canWin = true;
                    gameGame.forecedWin = true;
                }
            }
        }
    }
}
