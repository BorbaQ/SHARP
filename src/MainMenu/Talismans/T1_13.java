package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_13 extends TalismanA{
    public T1_13(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 250;
    }


    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization){
                if (upgraded) {power=350;}else{power=250;}
                for (int[] tali : game.talismans){
                    if (tali!=null){
                        power-=50;
                    }
                }
            }
            if (gameGame.isWinning){
                gameGame.fu+=power;
            }
        }
    }
}
