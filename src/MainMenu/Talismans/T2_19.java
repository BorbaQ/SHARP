package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Random;

public class T2_19 extends TalismanA{
    public T2_19(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }



    @Override
    public void TakeEffect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (gameGame!=null) {
            if (gameGame.initialization){
                game.scout1 = true;
                if (upgraded) {game.scout2 = true;}
                System.out.println("2-19");
            }

        }
    }
}
