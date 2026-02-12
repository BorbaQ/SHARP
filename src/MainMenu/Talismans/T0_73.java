package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;

public class T0_73 extends TalismanA{
    int numba = 0;
    public T0_73(Game gameContext, GameGame gameGameContext) {
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
            numba++;
            if (upgraded) {
                if (numba == 6) {
                    gameGame.addDoras();
                    numba = 0;
                }
            }else{
                if (numba == 9) {
                    gameGame.addDoras();
                    numba = 0;
                }
            }
        }
    }
}
