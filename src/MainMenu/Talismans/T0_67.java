package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;

public class T0_67 extends TalismanA{
    public T0_67(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 20;
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning){
                for (int tile : gameGame.hand){
                    if(tile < 20 || tile%10==1 || tile%10 ==9){
                        return;
                    }
                }
                if (upgraded){
                    power += 30;
                }else {
                    power += 20;
                }
                gameGame.fu+=power;
            }
        }
    }
}
