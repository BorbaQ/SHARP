package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_21 extends TalismanA{
    public T1_21(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }
    boolean haku = false;
    boolean hatsu = false;
    boolean chun = false;

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization) {
                hatsu = false;
                haku = false;
                chun = false;
            }
            if (gameGame.isWinning) {
                for (int tile : gameGame.hand){
                    if (tile ==15){
                        chun = true;
                    }else if (tile ==16){
                        haku = true;
                    } else if (tile ==17) {
                        hatsu = true;
                    }
                }
                int powerfullnumba = 0;
                if (chun){powerfullnumba++;}
                if (haku){powerfullnumba++;}
                if (hatsu){powerfullnumba++;}
                gameGame.fu*= (int) Math.pow(2, powerfullnumba);
                if (upgraded){
                    gameGame.han+=3*powerfullnumba;
                }
            }

        }
    }
}
