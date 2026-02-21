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

public class T2_29 extends TalismanA{
    public T2_29(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, FontFormatException {
        if (gameGame!=null) {
            if (gameGame.discard!=0) {
                for (int k = 0; k < Main.mainWindow.game.DoraTiles.size(); k++) {
                    if (Main.mainWindow.game.DoraTiles.get(k) % 10 == 9) {
                        if (Objects.equals((Main.mainWindow.game.DoraTiles.get(k) / 10 * 10) + 1, gameGame.discard)) {
                            power += (upgraded ? 30 : 20);
                        }
                    } else if (Objects.equals(Main.mainWindow.game.DoraTiles.get(k) + 1, gameGame.discard)) {
                        power += (upgraded ? 30 : 20);
                    }
                }

                for (int soul : Main.mainWindow.game.SoulTiles) {
                    if (gameGame.discard == soul) {
                        power += (upgraded ? 30 : 20);
                    }
                }
            }
        }
    }
}
