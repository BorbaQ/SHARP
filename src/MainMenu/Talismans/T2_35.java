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

public class T2_35 extends TalismanA{
    public T2_35(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    Random rand = new Random();

    @Override
    public void TakeEffect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, FontFormatException {
        if (gameGame!=null) {
            if (gameGame.isWinning){
                int yakusby2 = gameGame.yakusS.size()/2;
                for(int i = 0; i < yakusby2; i++){
                    gameGame.han+= (upgraded?(rand.nextInt(3,7)): (rand.nextInt(0,7)))-2;
                }
            }
        }
    }
}
