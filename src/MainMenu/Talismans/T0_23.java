package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;

public class T0_23 extends TalismanA{
    int iCanCountToSix =0;
    public T0_23(Game gameContext, GameGame gameGameContext) {
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
            iCanCountToSix++;
            if(iCanCountToSix==6) {
                if (!upgraded) {power+=10;}else{power+=20;}
                iCanCountToSix=0;
            }
            if (gameGame.isWinning){
                gameGame.fu += power;
                if (gameGame.wallIndex <=12){if(!upgraded){gameGame.han+=12;}else{gameGame.han+=24;}}
                if (gameGame.wallIndex>=24){gameGame.han+=8;}else{gameGame.han+=16;}
            }
        }
    }
}
