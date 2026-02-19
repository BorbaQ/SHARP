package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T2_7 extends TalismanA{
    public T2_7(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    Random rand = new Random();
    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning){
                if (gameGame.lastTile/10==4 || gameGame.lastTile==450) {
                    if (upgraded) {
                        int index = rand.nextInt(25,34);
                        game.fuval[index]= (int)(game.fuval[index]*1.1);
                    }
                    int index = rand.nextInt(25,34);
                    game.fuval[index]= (int)(game.fuval[index]*1.1);
                }
            }
        }
    }
}
