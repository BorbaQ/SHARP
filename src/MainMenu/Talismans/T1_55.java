package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_55 extends TalismanA{
    public T1_55(Game gameContext, GameGame gameGameContext) {
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
                for (int i = 0;i < game.fuval.length;i++){
                    if ((game.fuval[i]>= 200 && !upgraded) || (game.fuval[i]>=150 && upgraded)){
                        game.SoulTiles.add(game.soulBufforList.get(i));
                        game.soulBufforList.remove(i);
                    }
                }
            }
        }
    }
}
