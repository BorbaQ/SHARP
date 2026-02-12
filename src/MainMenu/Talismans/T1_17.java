package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_17 extends TalismanA{
    public T1_17(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }

    boolean firstWin =false;

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization){
                firstWin = true;
            }
            if (gameGame.isWinning) {
                firstWin = false;
                if (gameGame.han <13 && !upgraded) {
                    return;
                }
                if (gameGame.han <10 && upgraded) {
                    return;
                }
                game.Money+=13;
            }

        }
    }
}
