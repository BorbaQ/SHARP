package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;

public class T0_25 extends TalismanA{
    public T0_25(Game gameContext, GameGame gameGameContext) {
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
                if (gameGame.tenpai.get(gameGame.discardIndex).size() ==1 ) {
                    if (!upgraded) {
                        gameGame.han += 8;
                    } else {
                        gameGame.han += 12;
                    }
                }
            }
        }
    }
}
