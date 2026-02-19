package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_45 extends TalismanA{
    public T1_45(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 13;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    Random rand = new Random();
//    TODO done
    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization) {
                if (upgraded) {
                    game.fuval[rand.nextInt(25,34)]*=5;
                }else{
                    game.fuval[rand.nextInt(25,34)]*=3;
                }
            }
            if (gameGame.isWinning){
                if ((gameGame.lastTile > 40 && gameGame.lastTile < 50) || gameGame.lastTile == 450) {
                    power--;
                }
                if (power <= 0 || power >= 100 ) {
                    gameGame.createVine = true;
                    power = 100000;
                }
            }

        }
    }
}
