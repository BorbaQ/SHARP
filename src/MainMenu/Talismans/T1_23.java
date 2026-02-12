package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_23 extends TalismanA{
    public T1_23(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }
    boolean ton = false;
    boolean nan = false;
    boolean shaa = false;
    boolean pei = false;

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization) {
                ton = false;
                nan = false;
                shaa = false;
                pei = false;
            }
            if (gameGame.isWinning) {
                for (int tile : gameGame.hand){
                    if (tile ==11){
                        ton = true;
                    }else if (tile ==12){
                        nan = true;
                    } else if (tile ==13) {
                        shaa = true;
                    }else if (tile ==14) {
                        pei = true;
                    }
                }
                int powerfullnumba = 0;
                if (ton){powerfullnumba++;}
                if (nan){powerfullnumba++;}
                if (shaa){powerfullnumba++;}
                if (pei){powerfullnumba++;}
                gameGame.fu = (int)(gameGame.fu * Math.pow(1.5, powerfullnumba));
                if (upgraded){
                    gameGame.han+=3*powerfullnumba;
                }
            }

        }
    }
}
