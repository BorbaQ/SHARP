package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_101 extends TalismanA{
    public T1_101(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 10000;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    Random rand = new Random();
    //    TODO done
    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization) {
                gameGame.openBonus+=(upgraded? 15:10);
                game.Money+=(upgraded? 30:20);
            }
            if (gameGame.isWinning) {
                gameGame.han+=(upgraded?25:15);
                gameGame.fu+=(upgraded?500:300);
            }
        }
    }
}
