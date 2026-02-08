package MainMenu.Talismans;

import MainMenu.Deck;
import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;
import java.util.Random;

public class T0_53 extends TalismanA{
    public T0_53(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 0;
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    int kansNum =0;

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization){
                kansNum =0;
            }
            if (gameGame.Kans > kansNum){
                kansNum =gameGame.Kans;
                for (int i : Deck.uniqueTiles) {
                    if (i == gameGame.KansArray.getLast()) {
                        if (upgraded) {
                            game.fuval[i] += 80;
                        }else{
                            game.fuval[i] += 50;
                        }
                    }
                }
            }
        }
    }
}
