package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class T3_11 extends TalismanA{
    public T3_11(Game gameContext, GameGame gameGameContext) {
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
                gameGame.locked+=3;
            }
            if (first) {
                first = false;
                power+= gameGame.locked*(upgraded ? 3 : 2);
                for (int i = 36-gameGame.locked; i <36; i++) {
                    for (int soul : Main.mainWindow.game.SoulTiles) {
                        if (gameGame.TileWallArray.get(i) == soul) {
                            power += (upgraded ? 2 : 1);
                        }
                    }
                }
            }
            if (gameGame.isWinning){
                gameGame.han*= power;
            }
        }
    }
}
