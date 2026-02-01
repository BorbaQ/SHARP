package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

public class T0_5 extends TalismanA {

    public T0_5(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null){
            if (gameGame.isWinning) {
                if (upgraded) {
                    if (gameGame.lastTile == 250 || gameGame.lastTile == 350 || gameGame.lastTile == 450 || gameGame.lastTile %10==5 ) {
                        game.fuval[12] +=25;
                        game.fuval[21] +=25;
                        game.fuval[30] +=25;
                    }
                }else{
                    if (gameGame.lastTile == 250 || gameGame.lastTile == 350 || gameGame.lastTile == 450 ) {
                        game.fuval[12] +=25;
                        game.fuval[21] +=25;
                        game.fuval[30] +=25;
                    }
                }
            }
        }
    }
}
