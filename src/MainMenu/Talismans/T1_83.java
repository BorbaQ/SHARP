package MainMenu.Talismans;

import MainMenu.Deck;
import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_83 extends TalismanA{
    public T1_83(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    boolean first = false;

    @Override
    public void TakeEffect() throws IOException, FontFormatException {
        if (gameGame != null) {
            if (gameGame.initialization) {
                game.locked+=3;
                first = true;
            }
            if (!gameGame.initialization && first){
                first = false;
                for(int i = 36- game.locked-1; i <36; i++){
                    int index =0;
                    for (int tile : Deck.uniqueTiles){
                        if (tile == gameGame.TileWallArray.get(i)) {
                            index = i;
                            break;
                        }
                    }

                    game.fuval[index]+=(upgraded ? 30 : 15);
                }
            }
        }
    }
}
