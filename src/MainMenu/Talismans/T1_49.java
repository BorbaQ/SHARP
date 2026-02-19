package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_49 extends TalismanA{
    public T1_49(Game gameContext, GameGame gameGameContext) {
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
            if (gameGame.isWinning){
                for (String yaku: gameGame.yakusS){
                    if (Objects.equals(yaku, "Chitoitsu (2)")){
                        power++;
                        gameGame.han*= (int) ((double) power /2);
                    }
                }
            }

        }
    }
}
