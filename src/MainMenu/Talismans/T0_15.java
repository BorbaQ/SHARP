package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

public class T0_15 extends TalismanA{
    boolean effectIg = true;
    public T0_15(Game gameContext, GameGame gameGameContext) {
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
                gameGame.locked+=3;
                effectIg = true;
            }
            if (gameGame.isWinning){
                if (effectIg){
                    for(int i = gameGame.locked; i > 0; i--){
                        if (gameGame.TileWallArray.get(gameGame.TileWallArray.size()-i)!=null) {
                            if (gameGame.TileWallArray.get(gameGame.TileWallArray.size() - i) > 100) {
                                if (gameGame.TileWallArray.get(gameGame.TileWallArray.size() - i) / 10 != 3) {
                                    continue;
                                }
                            }

                            if (gameGame.TileWallArray.get(gameGame.TileWallArray.size() - i) / 10 != 3) {
                                continue;
                            }
                            if (!upgraded) {
                                game.Money += 3;
                            } else {
                                game.Money += 5;
                            }
                        }

                    }
                    effectIg = false;
                }
            }
        }
    }
}
