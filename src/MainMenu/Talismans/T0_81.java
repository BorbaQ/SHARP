package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

public class T0_81 extends TalismanA{
    public T0_81(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 0;

    }
    boolean draho = false;
    boolean wind = false;
    boolean man = false;
    boolean pin = false;
    boolean sou = false;

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning) {
                draho = false;wind = false;man = false;pin = false;sou = false;
                int shitAssCounta = 0;
                for (int tile : gameGame.hand){
                    if ((tile>10 && tile < 15)){wind = true;}
                    if ((tile>14 && tile < 18)){draho = true;}
                    if ((tile>20 && tile < 30)){man = true;}
                    if ((tile>30 && tile < 40)){pin = true;}
                    if ((tile>40 && tile < 50)){sou = true;}
                }
                if (draho)shitAssCounta++;
                if (wind)shitAssCounta++;
                if (man)shitAssCounta++;
                if (pin)shitAssCounta++;
                if (sou)shitAssCounta++;
                if (shitAssCounta>2)return;
                if (upgraded){
                    gameGame.han+=8;
                }else{
                    gameGame.han+=6;
                }
            }
        }
    }
}
