package MainMenu.Talismans;

import MainMenu.Deck;
import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;
import java.util.Random;

public class T0_49 extends TalismanA{
    public T0_49(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 0;
    }
    boolean first;
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization){
                first = true;
            }
            if (first) {
                if (gameGame.discard != 0) {
                    first = false;
                    for (int i : Deck.uniqueTiles) {
                        if (i == gameGame.discard) {
                            if (upgraded) {
                                game.fuval[i] += 50;
                            }else{
                                game.fuval[i] += 30;
                            }
                        }
                    }
                }
            }
        }
    }
}
