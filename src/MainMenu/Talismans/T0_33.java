package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

public class T0_33 extends TalismanA{
    public T0_33(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (game.isShop) {
            if (upgraded) {
                game.freeRefresh += 2;
            } else {
                game.freeRefresh += 1;
            }
        }
    }
}
