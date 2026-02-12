package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Arrays;
import java.util.Objects;

public class T0_59 extends TalismanA{
    public T0_59(Game gameContext, GameGame gameGameContext) {
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
            if (gameGame.isWinning){
                if (gameGame.wallIndex >= 24){if (upgraded){gameGame.han+=6;}else{gameGame.han+=4;}}
                for (int[] idk : game.talismans){
                    if (Arrays.equals(idk, new int[]{0, 57}) || Arrays.equals(idk,new int[]{0,61}) || Arrays.equals(idk, new int[]{0,63})) {
                        gameGame.han+=2;
                    }
                }
            }
        }
    }
}
