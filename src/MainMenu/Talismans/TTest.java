package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Talismans.TalismanA;

public class TTest extends TalismanA {
//    fuck ass armour
    int fuBonus = 0;
    public TTest(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 1;
    }

    @Override
    public void handleUpgrade() {
        power++;
    }

    @Override
    public void TakeEffect() {
        gameGame.han *= (int) Math.pow(3,power);
    }
}
