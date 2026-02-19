package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T2_13 extends TalismanA{
    public T2_13(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
        gameGame.upgradeInvite=true;
        System.out.println("2-13");
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {

        }
    }
}
