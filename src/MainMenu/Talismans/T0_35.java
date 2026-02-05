package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;

public class T0_35 extends TalismanA{
    public T0_35(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 1;
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning){
                for (int i = 0; i < gameGame.hand.length - 1; i++) {
                    if (gameGame.hand[i]/10==4) {
                        if (!upgraded) {
                            gameGame.fu+=10;
                        }else{
                            gameGame.fu+=15;
                        }
                    }
                }
            }
        }
    }
}
