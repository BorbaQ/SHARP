package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_5 extends TalismanA{
    public T1_5(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 8;
    }


    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization){
                if (upgraded) {power=12;}else {power = 8;}
            }
            if (gameGame.isWinning){
                gameGame.han+=power;
                power--;

            }
        }
    }
}
