package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

public class T0_1 extends TalismanA {
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    public T0_1(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 0;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.winForgo) {
                System.out.println("Forgo's mod " + power);
                power++;
            }
            if (gameGame.isWinning) {
                System.out.println("You win! power:" + power + " fu:" + gameGame.fu + " upgraded:" + upgraded);
                if (upgraded) {
                    gameGame.fu = gameGame.fu + power * 60;
                } else {
                    gameGame.fu = gameGame.fu + power * 40;
                }
                System.out.println("fu after one talisman usage" + gameGame.fu);
            }
        }
    }
}
