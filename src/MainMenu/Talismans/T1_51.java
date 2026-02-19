package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Random;

public class T1_51 extends TalismanA{
    public T1_51(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    Random rand = new Random();
    @Override
    public void TakeEffect() throws IOException, FontFormatException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (gameGame!=null) {
            if (!gameGame.isWinning) {
                if (gameGame.canWin) {

                }else{
                    if (gameGame.discard%10==1 || gameGame.discard%10==9) {
                        gameGame.switchTile(gameGame.discardIndex);
                        power++;
                    }
                }
            }
            if (gameGame.isWinning){
                if (upgraded){
                    gameGame.han += power * (gameGame.han / 5);
                }else {
                    gameGame.han += power * (gameGame.han / 10);
                }
            }

        }
    }
}
