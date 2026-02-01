package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

public class T0_3 extends TalismanA{
    public T0_3(Game gameContext, GameGame gameGameContext) {
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
                game.bargain = 2;
            } else {
                game.bargain = 1;
            }
        }
    }
}
