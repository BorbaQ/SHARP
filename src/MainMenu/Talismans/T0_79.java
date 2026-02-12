package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

public class T0_79 extends TalismanA{
    public T0_79(Game gameContext, GameGame gameGameContext) {
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
            if (gameGame.isWinning) {
                if (game.Money < 10) {
                    if (upgraded) {
                        gameGame.fu += 120;
                    }else{
                        gameGame.fu += 80;
                    }
                }
            }
        }
    }
}
