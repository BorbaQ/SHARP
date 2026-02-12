package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_3 extends TalismanA{
    public T1_3(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 0;
    }


    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning){
                for (int tileIdndex =0; tileIdndex < gameGame.hand.length; tileIdndex++) {
                    for (int k = 0; k < Main.mainWindow.game.DoraTiles.size(); k++) {
                        if (Objects.equals(Main.mainWindow.game.DoraTiles.get(k), gameGame.hand[tileIdndex])) {
                            gameGame.han++;
                            if (upgraded) {
                                gameGame.fu+=20;
                            }
                        }
                    }
                }
                for (int kantile : gameGame.KansArray) {
                    for (int k = 0; k < Main.mainWindow.game.DoraTiles.size(); k++) {
                        if (Objects.equals(Main.mainWindow.game.DoraTiles.get(k), kantile)) {
                            gameGame.han+=4;
                            if (upgraded) {
                                gameGame.fu+=80;
                            }
                        }
                    }
                }

            }
        }
    }
}
