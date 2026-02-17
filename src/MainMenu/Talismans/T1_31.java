package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_31 extends TalismanA{
    public T1_31(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning) {
                int sum =0;
               for (int tile : gameGame.hand){
                   if (tile>100){
                       sum+=5;
                   } else if (tile<20) {
                       continue;
                   }else{
                       sum+=tile%10;
                   }
               }
               if (sum >= 80){
                   if (upgraded){
                       gameGame.han*=10;
                   }else{
                       gameGame.han*=5;
                   }
               }
            }
        }
    }
}
