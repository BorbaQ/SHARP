package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_39 extends TalismanA{
    public T1_39(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization){
                gameGame.locked+=3;
                if (upgraded) {
                    gameGame.openBonus += 9;
                }else{
                    gameGame.openBonus += 6;
                }
            }

        }
    }
}
