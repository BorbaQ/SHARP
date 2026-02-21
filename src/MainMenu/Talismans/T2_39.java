package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class T2_39 extends TalismanA{
    public T2_39(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    boolean first = false;
    int counta = 18;

    @Override
    public void TakeEffect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, FontFormatException {
        if (gameGame!=null) {
            if (gameGame.initialization){
                game.heavenlyRestriction = true;
                power =(int)(game.amountOfBoughtTalismans*(upgraded?0.3:0.2));
            }
            if (gameGame.isWinning){
                gameGame.han+=power;
            }
        }
    }
}
