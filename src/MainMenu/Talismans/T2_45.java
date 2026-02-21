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

public class T2_45 extends TalismanA{
    public T2_45(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    public int yakumans =0;

    @Override
    public void TakeEffect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, FontFormatException {
        if (gameGame!=null) {
            if (gameGame.isWinning){
                for (String yaku : gameGame.yakusS){
                    int start = yaku.lastIndexOf("(");
                    int end = yaku.lastIndexOf(")");
                    String result = "";
                    if (start != -1 && end != -1 && end > start) {
                        result = yaku.substring(start, end + 1);
                    }
                    if (result.equals("(Yakuman)")){
                        yakumans++;
                    }
                }
                for (int i =0;i<yakumans;i++){
                    for (int tile : gameGame.hand){
                        for (int soul : Main.mainWindow.game.SoulTiles){
                            if (tile==soul){
                                gameGame.han+=(upgraded?8:5);
                            }
                        }
                    }
                }
            }
        }
    }
}
