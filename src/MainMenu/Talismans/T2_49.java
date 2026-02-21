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

public class T2_49 extends TalismanA{
    public T2_49(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    int shitasscounta = 0;

    @Override
    public void TakeEffect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, FontFormatException {
        if (gameGame!=null) {
            if (gameGame.initialization){
                shitasscounta=(upgraded? 9:12);
            }
            if (gameGame.isTenpai){
                shitasscounta--;
                if (shitasscounta==0){
                    gameGame.isWinning = true;
                    gameGame.forecedWin = true;
                    shitasscounta = (upgraded? 9:12);
                }
            }
        }
    }
}
