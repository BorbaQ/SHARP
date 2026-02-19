package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T2_5 extends TalismanA{
    public T2_5(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    boolean first =false;

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization){
                first = true;
            }
            if (!gameGame.initialization && first){
                first = false;
                for (int i =0; i< gameGame.switches/(upgraded?1:2);i++){
                    game.addSoulTile();
                }
            }
        }
    }
}
