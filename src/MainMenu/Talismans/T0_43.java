package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;
import java.util.Random;

public class T0_43 extends TalismanA{


    public T0_43(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 0;
    }
    boolean first;

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization){
                first = true;
            }
            if (gameGame.isWinning) {
                if (first) {
                    if (!upgraded) {
                        game.Money += gameGame.yakusS.size();
                    }else{
                        game.Money += gameGame.yakusS.size()*2;
                    }
                    first = false;
                }
            }
        }
    }
}
