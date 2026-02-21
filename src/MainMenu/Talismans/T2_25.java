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

public class T2_25 extends TalismanA{
    public T2_25(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    int kanState =0;

    @Override
    public void TakeEffect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, FontFormatException {
        if (gameGame!=null) {
            if (gameGame.forecedWin){
                gameGame.yakusS.add("Chankan (1)");
                gameGame.han+= 1 + (upgraded ? 8 : 4);
            }else
            if (gameGame.isTenpai){
                if (kanState!=gameGame.Kans){
                    gameGame.isWinning = true;
                    gameGame.forecedWin = true;
                }
            }else{
                kanState=gameGame.Kans;
            }
        }
    }
}
