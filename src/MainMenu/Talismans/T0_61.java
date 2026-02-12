package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Arrays;
import java.util.Objects;

public class T0_61 extends TalismanA{
    int iCanCountToSix =0;
    public T0_61(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 90;
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
                    power = 120;
                }else{
                    power  = 90;
                }
            }
            iCanCountToSix++;
            if(iCanCountToSix==6) {
                power -= 20;
                iCanCountToSix=0;
            }
            if (gameGame.isWinning){
                gameGame.fu += power;
                for (int[] idk : game.talismans){
                    if (Arrays.equals(idk, new int[]{0, 57}) || Arrays.equals(idk, new int[]{0,59}) || Arrays.equals(idk, new int[]{0,63})) {
                        gameGame.fu+=60;
                    }
                }
            }
        }
    }
}
