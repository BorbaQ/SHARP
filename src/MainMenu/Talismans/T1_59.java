package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_59 extends TalismanA{
    public T1_59(Game gameContext, GameGame gameGameContext) {
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
            if (gameGame.initialization){
                if (upgraded){
                    if (game.Money >= 30) {
                        game.Money -= 30;
                    } else {
                        game.Money = 0;
                    }
                    game.Money += 30;
                }else {
                    if (game.Money >= 20) {
                        game.Money -= 20;
                    } else {
                        game.Money = 0;
                    }
                    game.Money += 20;
                }
            }
        }
    }
}
