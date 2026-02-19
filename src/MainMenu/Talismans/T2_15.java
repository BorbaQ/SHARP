package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Random;

public class T2_15 extends TalismanA{
    public T2_15(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    Random rand = new Random();

    @Override
    public void TakeEffect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (gameGame!=null) {
            if (gameGame.initialization){
                if (upgraded) {
                    addRandoTalismans();
                    System.out.println("2-15");
                }
                addRandoTalismans();
                System.out.println("2-15");

            }

        }
    }

    void addRandoTalismans() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (int i =0; i<game.talismansAct.length; i++){
            if (game.talismansAct[i] ==null && game.talismans[i]==null){
                int john = rand.nextInt(11);
                if (john==0){
                    game.talismans[i] = new int[] {2,22};
                    game.talismansAct[i] = Game.talismansAlles.get("2-22").getDeclaredConstructor(Game.class , GameGame.class).newInstance(game,gameGame);
                    break;
                }else if (john==1){
                    int doe = rand.nextInt(5);
                    game.talismans[i] = new int[] {3,doe*2};
                    game.talismansAct[0] = Game.talismansAlles.get("3-"+(doe*2)).getDeclaredConstructor(Game.class , GameGame.class).newInstance(game,gameGame);
                    break;
                }else{
                    int doe = rand.nextInt(26);
                    game.talismans[i] = new int[] {2,doe*2};
                    game.talismansAct[0] = Game.talismansAlles.get("2-"+(doe*2)).getDeclaredConstructor(Game.class , GameGame.class).newInstance(game,gameGame);
                    break;
                }
            }
        }
    }
}
