package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;

public class T0_65 extends TalismanA{
    public T0_65(Game gameContext, GameGame gameGameContext) {
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
            if (gameGame.initialization){
                power =0;
                if (upgraded) {
                    power += game.moneySpentOnReloads*10;
                }else{
                    power+= game.moneySpentOnReloads*5;
                }
            }
        }
    }
}
