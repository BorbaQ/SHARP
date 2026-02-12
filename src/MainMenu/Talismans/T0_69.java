package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;

public class T0_69 extends TalismanA{
    public T0_69(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 40;
    }

    @Override
    public void handleUpgrade() {
        upgraded = true; power=80;
    }
    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning){
                gameGame.fu+=power;
            }
        }
    }
}
