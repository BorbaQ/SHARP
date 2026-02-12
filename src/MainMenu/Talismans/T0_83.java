package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Random;

public class T0_83 extends TalismanA{
    public T0_83(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 0;

    }
    Random rand = new Random();

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning) {
                if (upgraded) {
                    gameGame.fu+= rand.nextInt(0,301);
                }else{
                    gameGame.fu+= rand.nextInt(0,151);
                }
            }
        }
    }
}
