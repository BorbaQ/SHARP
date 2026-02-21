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

public class T2_43 extends TalismanA{
    public T2_43(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    public int[] fuval2 = game.fuval;

    @Override
    public void TakeEffect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, FontFormatException {
        if (gameGame!=null) {
            for (int i = 0; i<fuval2.length;i++) {
                if (fuval2[i]!=game.fuval[i]) {
                    game.fuval[i] += game.fuval[i]-fuval2[i];
                    if(upgraded) {
                        game.fuval[i] += (int)((game.fuval[i]-fuval2[i])*0.5);
                    }
                }
            }
        }
    }
}
