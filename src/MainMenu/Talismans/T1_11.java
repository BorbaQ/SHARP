package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_11 extends TalismanA{
    public T1_11(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 7;
    }
    int counta =0;


    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization){
                counta++;
                game.Money+=power;
                if (!upgraded && counta==2){
                    power++;
                    counta=0;
                }else if (upgraded){
                    power++;
                    counta=0;
                }
            }
        }
    }
}
