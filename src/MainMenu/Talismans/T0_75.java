package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;

public class T0_75 extends TalismanA{
    int numba = 0;
    public T0_75(Game gameContext, GameGame gameGameContext) {
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
                gameGame.addDoras();
                if (upgraded){
                    gameGame.fu+=20;
                }
            }
        }
    }
}
