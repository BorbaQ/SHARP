package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_25 extends TalismanA{
    public T1_25(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }


    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning) {
                if (gameGame.yakusS.contains("Pinfu (1)") || gameGame.yakusS.contains("Kokushi Musou Juusanmenmachi (Double Yakuman)")) {
                    if (upgraded) {
                        gameGame.fu*=5;
                    }else {
                        gameGame.fu *= 4;
                    }
                }
            }

        }
    }
}
