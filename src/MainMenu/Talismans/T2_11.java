package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T2_11 extends TalismanA{
    public T2_11(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (!gameGame.initialization && !gameGame.isWinning){
                for (int tileIdndex =0; tileIdndex < gameGame.hand.length; tileIdndex++) {
                    for (int k = 0; k < Main.mainWindow.game.DoraTiles.size(); k++) {
                        if (Main.mainWindow.game.DoraTiles.get(k) % 10 == 9) {
                            if (Objects.equals((Main.mainWindow.game.DoraTiles.get(k) / 10 * 10) + 1, gameGame.hand[tileIdndex])) {
                            }else {return;}
                        } else if (Objects.equals(Main.mainWindow.game.DoraTiles.get(k) + 1, gameGame.hand[tileIdndex])) {
                        }else {return;}
                    }
                }
                for (int kantile : gameGame.KansArray) {
                    for (int k = 0; k < Main.mainWindow.game.DoraTiles.size(); k++) {
                        if (Main.mainWindow.game.DoraTiles.get(k) % 10 == 9) {
                            if (Objects.equals((Main.mainWindow.game.DoraTiles.get(k) / 10 * 10) + 1, kantile)) {
                            }else {return;}
                        } else if (Objects.equals(Main.mainWindow.game.DoraTiles.get(k) + 1, kantile)) {
                        }else {return;}
                    }
                }
                gameGame.canWin = true;
                gameGame.forecedWin = true;
                System.out.println("2-11");
            }
        }
    }
}
