package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_27 extends TalismanA{
    public T1_27(Game gameContext, GameGame gameGameContext) {
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
                if (upgraded) {
                    power = game.talismansSold*50;
                }else{
                    power = game.talismansSold*30;
                }
            }
            if (gameGame.isWinning) {
                gameGame.fu  += power;
            }
        }
    }
}
