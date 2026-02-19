package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_99 extends TalismanA{
    public T1_99(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 10000;
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
        }
    }
}
