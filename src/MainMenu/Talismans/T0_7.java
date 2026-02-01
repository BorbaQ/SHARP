package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

public class T0_7 extends TalismanA{

    public T0_7(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        initial = true;
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization) {
                gameGame.locked +=3;
                if (upgraded) {game.Money+=9;} else {game.Money += 6;}
            }
        }
    }
}
