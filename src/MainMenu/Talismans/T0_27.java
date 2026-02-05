package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;

public class T0_27 extends TalismanA{
    public T0_27(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 1;
    }
    boolean[] iCanCountToSixPartTwoElectricBungaloo = new boolean[5];

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning){
                for(int i = 0; i<gameGame.hand.length-1;i++){
                    if(gameGame.hand[i] < 20){continue;
                    }
                    for(int j = i; j<gameGame.hand.length-1;j++){
                        if(gameGame.hand[i]+1 == gameGame.hand[j]){iCanCountToSixPartTwoElectricBungaloo[0] = true;}
                        if(gameGame.hand[i]+2 == gameGame.hand[j]){iCanCountToSixPartTwoElectricBungaloo[1] = true;}
                        if(gameGame.hand[i]+3 == gameGame.hand[j]){iCanCountToSixPartTwoElectricBungaloo[2] = true;}
                        if(gameGame.hand[i]+4 == gameGame.hand[j]){iCanCountToSixPartTwoElectricBungaloo[3] = true;}
                        if(gameGame.hand[i]+5 == gameGame.hand[j]){iCanCountToSixPartTwoElectricBungaloo[4] = true;}
                    }
                    if (iCanCountToSixPartTwoElectricBungaloo[0] && iCanCountToSixPartTwoElectricBungaloo[1] && iCanCountToSixPartTwoElectricBungaloo[2] && iCanCountToSixPartTwoElectricBungaloo[3] && iCanCountToSixPartTwoElectricBungaloo[4]){
                        if (!upgraded) {
                            gameGame.han += 4;
                        }else{
                            gameGame.han += 6;
                        }
                        break;
                    }
                }

            }
        }
    }
}
