package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T2_9 extends TalismanA{
    public T2_9(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    int amoutOfSouls = game.SoulTiles.size();
    int[] fuval2 = game.fuval;

    boolean first = false;
    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization){
                if (amoutOfSouls !=  game.SoulTiles.size()){
                    power+= (game.SoulTiles.size()-amoutOfSouls)*(upgraded?1:3);
                    amoutOfSouls = game.SoulTiles.size();
                }
                for (int i =0; i<fuval2.length;i++) {
                    if (fuval2[i]!=game.fuval[i]){
                        power+=(upgraded?1:3);
                    }
                }

            }
            if (!gameGame.initialization && first){
                if (gameGame.locked >0){
                    power+= (gameGame.locked)*(upgraded?1:3);
                }
            }
            if (gameGame.isWinning){
                gameGame.han*= (int) ((double) power /(upgraded?2:10));
                System.out.println("2-9");
            }
        }
    }
}
