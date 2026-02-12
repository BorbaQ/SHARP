package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_7 extends TalismanA{
    public T1_7(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
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
                if (upgraded) {power=3;}else {power = 2;}
            }
            if (gameGame.isWinning){
                power++;
                gameGame.han+=power;
            }
        }
    }
}
