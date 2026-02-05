package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;

public class T0_17 extends TalismanA{
    boolean effectIg = true;
    public T0_17(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 10;
    }

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization){
                gameGame.locked+=3;
                effectIg = true;
            }
            if (gameGame.isWinning){
                if (effectIg) {
                    for (int i = gameGame.locked; i > 0; i--) {
                        for (Integer dora : game.DoraTiles) {
                            if (Objects.equals(gameGame.TileWallArray.get(gameGame.TileWallArray.size() - i), dora)) {
                                if (!upgraded) {
                                    power +=25;
                                } else {
                                    power +=50;
                                }
                            }
                        }
                    }
                    effectIg = false;
                }
                gameGame.fu+=power;
            }
        }
    }
}
