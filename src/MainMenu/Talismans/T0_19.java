package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;

public class T0_19 extends TalismanA{
    public T0_19(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 10;
    }
    boolean[] numbas = new boolean[9];

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning){
                numbas = new boolean[9];
                for (int tile: gameGame.hand) {
                    if (tile%10==1){numbas[0] = true;}
                    if (tile%10==2){numbas[1] = true;}
                    if (tile%10==3){numbas[2] = true;}
                    if (tile%10==4){numbas[3] = true;}
                    if (tile%10==5 || tile%10==0){numbas[4] = true;}
                    if (tile%10==6){numbas[5] = true;}
                    if (tile%10==7){numbas[6] = true;}
                    if (tile%10==8){numbas[7] = true;}
                    if (tile%10==9){numbas[8] = true;}
                }
                if(numbas[0] && numbas[1] && numbas[2] && numbas[3] && numbas[4] && numbas[5] && numbas[6] && numbas[7] && numbas[8]){
                    if (!upgraded){power+=40;}else{power+=60;}
                }
                gameGame.fu+=power;
            }
        }
    }
}
