package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_19 extends TalismanA{
    public T1_19(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }
    int divider=10;

    @Override
    public void handleUpgrade() {
        upgraded = true;divider =5;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning) {
                gameGame.han+=(int)(game.Money/divider);
            }

        }
    }
}
