package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T2_3 extends TalismanA{
    public T2_3(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    int power2 =0;

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.isWinning) {
                int souls=0;
                for (int tile : game.SoulTiles){
                    if (gameGame.lastTile==tile){
                        power++;
                    }
                    for (int tile2 : gameGame.hand){
                        if(tile2==tile){
                            souls++;
                        }
                    }
                }

                power2+=(upgraded? 2:1)*souls;
                gameGame.han*= power;
                gameGame.han+=power2;
            }
        }
    }
}
