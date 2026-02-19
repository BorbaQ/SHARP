package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_77 extends TalismanA{
    public T1_77(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    @Override
    public void TakeEffect() throws IOException, FontFormatException {
        if (gameGame != null) {
            if (gameGame.isWinning) {
                if (!Main.mainWindow.game.DoraTiles.isEmpty()) {
                    for (int k = 0; k < Main.mainWindow.game.DoraTiles.size(); k++) {
                        if (Main.mainWindow.game.DoraTiles.get(k) % 10 == 9) {
                            if (Objects.equals((Main.mainWindow.game.DoraTiles.get(k) / 10 * 10) + 1, gameGame.lastTile)) {
                                gameGame.han += upgraded ? 3 : 0;

                                int index = game.soulBufforList.indexOf(gameGame.lastTile);
                                game.SoulTiles.add(game.soulBufforList.get(index));
                                game.soulBufforList.remove(index);
                            }
                        } else if (Objects.equals(Main.mainWindow.game.DoraTiles.get(k) + 1, gameGame.lastTile)) {
                            gameGame.han += upgraded ? 3 : 0;

                            int index = game.soulBufforList.indexOf(gameGame.lastTile);
                            game.SoulTiles.add(game.soulBufforList.get(index));
                            game.soulBufforList.remove(index);
                        }
                    }
                }
            }
        }
    }
}
