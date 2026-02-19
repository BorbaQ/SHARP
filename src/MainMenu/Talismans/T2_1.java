package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T2_1 extends TalismanA{
    public T2_1(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning) {
                power+= (upgraded ? 8 : 1)* gameGame.switches;
                gameGame.han*=(upgraded?power/10:power/2);
            }
        }
    }
}
