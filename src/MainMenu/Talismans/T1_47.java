package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_47 extends TalismanA{
    public T1_47(Game gameContext, GameGame gameGameContext) {
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
    public void TakeEffect() throws IOException, FontFormatException {
        if (gameGame!=null) {
            if (!gameGame.isWinning) {
                if (gameGame.canWin) {

                }else{
                    if (gameGame.discard > 100){
                        gameGame.switchTile(gameGame.discardIndex);
                        if (upgraded){
                            power+=8;
                        }else{
                            power+=5;
                        }
                    } else if (gameGame.discard%10!=1 && gameGame.discard%10!=9) {
                        gameGame.switchTile(gameGame.discardIndex);
                        if (upgraded){
                            power+=8;
                        }else{
                            power+=5;
                        }
                    }
                }
            }
            if (gameGame.isWinning){
                gameGame.han+=power;
            }

        }
    }
}
