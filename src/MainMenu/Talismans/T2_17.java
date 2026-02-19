package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Random;

public class T2_17 extends TalismanA{
    public T2_17(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    int dora = 0;

    @Override
    public void TakeEffect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (gameGame!=null) {
            if (gameGame.isWinning){

                for (int tileIdndex =0; tileIdndex < gameGame.hand.length; tileIdndex++) {
                    if (gameGame.hand[tileIdndex]==350){
                        dora++;
                    }else {
                        if (gameGame.hand[tileIdndex]/10==3) {
                            for (int k = 0; k < Main.mainWindow.game.DoraTiles.size(); k++) {
                                if (Main.mainWindow.game.DoraTiles.get(k) % 10 == 9) {
                                    if (Objects.equals((Main.mainWindow.game.DoraTiles.get(k) / 10 * 10) + 1, gameGame.hand[tileIdndex])) {
                                        dora++;
                                    }
                                } else if (Objects.equals(Main.mainWindow.game.DoraTiles.get(k) + 1, gameGame.hand[tileIdndex])) {
                                    dora++;
                                }
                            }
                        }
                    }
                }
                for (int kantile : gameGame.KansArray) {
                    for (int k = 0; k < Main.mainWindow.game.DoraTiles.size(); k++) {
                        if (Main.mainWindow.game.DoraTiles.get(k) % 10 == 9) {
                            if (Objects.equals((Main.mainWindow.game.DoraTiles.get(k) / 10 * 10) + 1, kantile)) {
                                dora++;
                            }
                        } else if (Objects.equals(Main.mainWindow.game.DoraTiles.get(k) + 1, kantile)) {
                            dora++;
                        }
                    }
                }
                game.Money += dora*3;
                if (upgraded) {
                    game.Money+=5;
                }
                System.out.println("2-17");

            }

        }
    }
}
