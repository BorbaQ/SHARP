package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

public class T0_13 extends TalismanA{
    int honorCounter = 0;
    public T0_13(Game gameContext, GameGame gameGameContext) {
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
            if (gameGame.discard < 20){
                honorCounter++;
            }
            if (upgraded) {
                if (honorCounter == 12) {
                    game.addSoulTile();
                    honorCounter = 0;
                }
            }else{
                if (honorCounter == 18) {
                    game.addSoulTile();
                    honorCounter = 0;
                }
            }
        }
    }
}
