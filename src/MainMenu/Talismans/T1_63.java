package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_63 extends TalismanA{
    public T1_63(Game gameContext, GameGame gameGameContext) {
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
            if(gameGame.isWinning){
                for (int tile : gameGame.hand){
                    if (tile == 350 || (tile >30 && tile <40)){
                        if (upgraded){
                            if (rand.nextInt(2)==0){
                                game.Money+=1;
                            }
                        }else{
                            if (rand.nextInt(11)<=3){
                                game.Money+=1;
                            }
                        }
                    }
                }
            }
        }
    }
}
