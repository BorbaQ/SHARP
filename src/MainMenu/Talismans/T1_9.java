package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_9 extends TalismanA{
    public T1_9(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 1;
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
                counta=0;
            }
            if (gameGame.isWinning){
                counta++;
                if (upgraded){
                    if (counta==3){
                        power++;
                    }
                }else{
                    if (counta==4){
                        power++;
                    }
                }
                gameGame.han*=power;
            }
        }
    }
}
