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

public class T2_37 extends TalismanA{
    public T2_37(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 50;
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
                gameGame.locked+=3;
                first = true;
            }
            if (first) {
                if (counta < gameGame.locked){
                    counta = gameGame.locked - counta;
                    power =  (int)( power * (upgraded? 1.8:1.5));
                }else {
                    counta -= gameGame.locked;
                }
                first = false;
            }
            if (gameGame.isWinning){
                gameGame.fu+=power;
            }
        }
    }
}
