package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_29 extends TalismanA{
    public T1_29(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }
    int winCounta = 0;

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization){
                winCounta=0;
            }
            if (gameGame.isWinning) {
                winCounta++;
                if (winCounta==3) {
                    winCounta=0;
                    if (upgraded) {
                        game.Money+=3;
                    }else{
                        game.Money+=2;
                    }
                }
            }
        }
    }
}
