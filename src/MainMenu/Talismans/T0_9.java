package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

public class T0_9 extends TalismanA{

    public T0_9(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 10;
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning) {
                int HoT = 0;
                for(int tile : gameGame.hand){
                    if (tile %10 == 1 || tile%10== 9){
                        HoT++;
                    }
                }
                if (HoT >= 7){
                    if (upgraded) {
                        power+=60;
                    }else{
                        power+=40;
                    }
                }
                gameGame.fu+=power;
            }
        }
    }
}
