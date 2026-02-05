package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

public class T0_11 extends TalismanA{
    int soulCounter = 0;
    public T0_11(Game gameContext, GameGame gameGameContext) {
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
            if(gameGame.initialization){
                soulCounter=0;
            }
            for(int soul : game.SoulTiles){
                if (soul == gameGame.discard){
                    soulCounter++;
                    break;
                }
            }
            if (soulCounter==3){
                if (upgraded){
                    power+=game.SoulTiles.size()*2;
                }else{
                    power+=game.SoulTiles.size();
                }
                soulCounter=0;
            }
            if (gameGame.isWinning) {
                gameGame.han+= power;
            }
        }
    }
}
