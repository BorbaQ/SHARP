package MainMenu.Talismans;
import MainMenu.Game;
import MainMenu.GameGame;


public class T0_55 extends TalismanA{
    public T0_55(Game gameContext, GameGame gameGameContext) {
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
            if (gameGame.isWinning){
                for (int tile : gameGame.hand){
                    if (tile>20){
                        if (upgraded){
                            gameGame.fu+=5;
                        }else{
                            gameGame.han+=10;
                        }
                    }
                }
            }
        }
    }
}
