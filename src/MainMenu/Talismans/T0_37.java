package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;

public class T0_37 extends TalismanA{
    public T0_37(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 0;
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    boolean kijtostrzelil = false;
    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning){
                kijtostrzelil = true;
                for (int i = 0; i < gameGame.hand.length - 1; i++) {
                    if (!upgraded && (gameGame.hand[i]/10==1 || gameGame.hand[i]/10==2)) {
                        kijtostrzelil = false;
                        power = 0;
                        break;
                    } else if (gameGame.hand[i]/10==1 && upgraded) {
                        kijtostrzelil = false;
                        power = 0;
                        break;
                    }
                }
                if (kijtostrzelil) {
                    if (upgraded) {
                        power+=2;
                    }else{
                        power++;
                    }
                    gameGame.han +=power;
                }
            }
        }
    }
}
