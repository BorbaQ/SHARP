package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

import java.util.Objects;
import java.util.Random;

public class T1_1 extends TalismanA{
    public T1_1(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 0;
    }
    int kansNum =0;
    Random rand = new Random();

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization){
                kansNum =0;
            }
            if (gameGame.Kans != kansNum){
//TODO          DING DONG BING BONG (referencja) its made like for someone else and not yourself so it will break if you do 2 kans in one turn but GLGN (referencja) doing that     
                int randmsth = gameGame.KansArray.getLast();
                game.SoulTiles.add(game.soulBufforList.get(randmsth));
                game.soulBufforList.remove(randmsth);
                if (upgraded){
                    int randmsth2 = rand.nextInt(game.soulBufforList.size());
                    game.SoulTiles.add(game.soulBufforList.get(randmsth2));
                    game.soulBufforList.remove(randmsth2);
                }
            }
        }
    }
}
