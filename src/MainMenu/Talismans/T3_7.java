package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class T3_7 extends TalismanA{
    public T3_7(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    boolean first = true;

    @Override
    public void TakeEffect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, FontFormatException {
        if (gameGame!=null) {
            if (gameGame.isWinning) {
                int ownIndex = -2;
                for (int i = 0; i < game.talismansAct.length; i++) {
                    if ((game.talismansAct[i].getClass() == this.getClass())) {
                        ownIndex = i;
                    }
                }
                if (ownIndex < 8 && game.talismansAct[ownIndex + 1] != null) {
                    game.talismansAct[ownIndex + 1].TakeEffect();
                }
            }
        }
    }
}
