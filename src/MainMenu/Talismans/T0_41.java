package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;
import java.util.Random;

public class T0_41 extends TalismanA{
    public T0_41(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 0;
    }
    Random rand = new Random();
    int upgradeval = 5;

    @Override
    public void handleUpgrade() {
        upgraded = true;upgradeval=10;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning) {
                switch (rand.nextInt(4)){
                    case 0:
                        for (int i =0; i <=6;i++){
                            game.fuval[i]+=upgradeval;
                        }
                        break;
                    case 1:
                        for (int i =7; i <=15;i++){
                            game.fuval[i]+=upgradeval;
                        }
                        break;
                    case 2:
                        for (int i =16; i <=24;i++){
                            game.fuval[i]+=upgradeval;
                        }
                        break;
                    case 3:
                        for (int i =25; i <=33;i++){
                            game.fuval[i]+=upgradeval;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
