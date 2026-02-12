package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;

public class T0_71 extends TalismanA{
    public T0_71(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 2;
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning){
                for (int tile : gameGame.openOnes){
                    if (gameGame.wallIndex-1 == tile){
                        if (upgraded){
                            gameGame.fu*=3;
                        }else {
                            gameGame.fu*=2;
                        }
                    }
                }
            }
        }
    }
}
