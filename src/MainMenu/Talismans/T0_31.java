package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;

public class T0_31 extends TalismanA{
    public T0_31(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 2;
    }
    boolean shitassbool = true;
    int ton=0;
    int nan=0;
    int pei=0;
    int shaa =0;

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization){shitassbool = true;}
            if (gameGame.isWinning){
                if (shitassbool) {
                    for (int i = 0; i < gameGame.hand.length - 1; i++) {
                        switch (gameGame.hand[i]) {
                            case 11:
                                ton++;
                                break;
                            case 12:
                                nan++;
                                break;
                            case 13:
                                shaa++;
                                break;
                            case 14:
                                pei++;
                                break;
                            default:
                                break;
                        }
                        if (ton >= 3 || nan >= 3 || shaa >= 3 || pei >= 3) {
                            if (!upgraded) {power+=3;}else{power+=6;}
                            break;
                        }
                    }

                    shitassbool = false;
                }
            }
        }
    }
}
