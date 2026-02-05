package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;

public class T0_21 extends TalismanA{
    public T0_21(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 0;
    }


    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning){
               if (gameGame.discard%10==3){
                   if (!upgraded){
                       game.Money+=2;
                   }else{
                       game.Money+=3;
                   }
               }
            }
        }
    }
}
