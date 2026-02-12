package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.util.Objects;
import java.util.Random;

public class T1_15 extends TalismanA{
    public T1_15(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        power = 0;
    }
    Random rand = new Random();

    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (gameGame!=null) {
            if (gameGame.initialization){
                int shitassnumba =6;
                int shitassnumba2 =0;
                if (upgraded){shitassnumba=9;}
                int[] newOpen = new int[gameGame.openOnes.length+shitassnumba];
                for (int i =0; i<gameGame.openOnes.length; i++) {
                    newOpen[i] = gameGame.openOnes[i];
                    if (gameGame.openOnes[i]>=36- game.locked-shitassnumba){
                        shitassnumba2++;
                        newOpen[i]=-2;
                    }
                }
                for (int i =0; i<shitassnumba; i++) {
                    for (int j =0; i > newOpen.length;j++) {
                        if (newOpen[i] ==0 || newOpen[i] == -2){
                            newOpen[i] = 36-game.locked-i;
                        }
                    }
                }
                for (int i =0; i<shitassnumba2; i++) {
                    for (int j =0; i > newOpen.length;j++) {
                        if (newOpen[i] ==0 || newOpen[i] == -2){
                            newOpen[i] = rand.nextInt(2, 36-game.locked-shitassnumba+1);
                        }
                    }
                }


            }

        }
    }
}
