package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_43 extends TalismanA{
    public T1_43(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
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
                int[] doraThatCounts;
                if (upgraded) {
                    doraThatCounts = new int[game.DoraTiles.size()];
                }else{
                    doraThatCounts = new int[3];
                }
                for (int i =0; i<doraThatCounts.length;i++){
                    doraThatCounts[i]=game.DoraTiles.get(i);
                }
                for (int tile : doraThatCounts) {
                    if (gameGame.lastTile==tile){
                        game.SoulTiles.add(game.soulBufforList.indexOf(tile));
                        game.soulBufforList.remove((Integer) tile);
                    }
                }
            }

        }
    }
}
