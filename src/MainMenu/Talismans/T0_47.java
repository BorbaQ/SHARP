package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;
import java.util.Random;

public class T0_47 extends TalismanA{


    public T0_47(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 10;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    int souCut =0;

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.discard > 40 && gameGame.discard < 50) {
                souCut++;
                if (souCut==5) {
                    if (upgraded) {
                        power+=15;
                    }else{
                        power+=10;
                    }
                }
            }
            if (gameGame.isWinning){
                gameGame.fu+=power;
            }
        }
    }
}
