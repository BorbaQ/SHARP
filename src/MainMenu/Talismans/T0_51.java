package MainMenu.Talismans;

import MainMenu.Deck;
import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;
import java.util.Random;

public class T0_51 extends TalismanA{
    public T0_51(Game gameContext, GameGame gameGameContext) {
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
                for (int tile : gameGame.hand){
                    if (tile>20 || (tile%10>3 && tile%10<7)){
                        return;
                    }
                }
                if (upgraded){
                    gameGame.han*=10;
                }else{
                    gameGame.han*=5;
                }
            }
        }
    }
}
