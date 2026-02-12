package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Arrays;
import java.util.Objects;

public class T0_63 extends TalismanA{
    int iCanCountToSix =0;
    public T0_63(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 20;
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
                    power = 40;
                }else{
                    power  = 20;
                }
            }
            iCanCountToSix++;
            if(iCanCountToSix==6) {
                power += 15;
                iCanCountToSix=0;
            }
            if (gameGame.isWinning){
                gameGame.fu += power;
                for (int[] idk : game.talismans){
                    if (Arrays.equals(idk, new int[]{0, 57}) || Arrays.equals(idk, new int[]{0,59}) || Arrays.equals(idk, new int[]{0,61})) {
                        gameGame.fu+=10;
                    }
                }
            }
        }
    }
}
