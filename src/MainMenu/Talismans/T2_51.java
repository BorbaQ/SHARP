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

public class T2_51 extends TalismanA{
    public T2_51(Game gameContext, GameGame gameGameContext) {
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
            if (gameGame.initialization){
                first = true;
            }
            if (gameGame.isWinning&&first) {
                first = false;
                power += (upgraded?3:2)*(game.Money/2);
                game.Money = game.Money/2;

            }
            if (gameGame.isWinning){
                gameGame.han= (int)( gameGame.han*(power*0.1));
            }
        }
    }
}
