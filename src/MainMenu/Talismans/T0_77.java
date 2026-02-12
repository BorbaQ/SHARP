package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

public class T0_77 extends TalismanA{
    public T0_77(Game gameContext, GameGame gameGameContext) {
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
                gameGame.han+=gameGame.yakusS.size();
                if (upgraded) {
                    gameGame.fu+=gameGame.yakusS.size()*10;
                }
            }
        }
    }
}
