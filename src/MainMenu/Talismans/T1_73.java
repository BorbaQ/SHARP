package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_73 extends TalismanA{
    public T1_73(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    int originalSwitch =0;
    Random rand = new Random();
    @Override
    public void TakeEffect() throws IOException, FontFormatException {
        if (gameGame!=null) {
            if(gameGame.initialization){
                originalSwitch = gameGame.switches;
            }
            if (gameGame.isWinning){
                if (gameGame.switches >= originalSwitch){
                    gameGame.han*= gameGame.switches + (upgraded?3:1);
                }
            }
        }
    }
}
