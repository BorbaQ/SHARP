package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class T2_21 extends TalismanA{
    public T2_21(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }



    @Override
    public void TakeEffect() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, FontFormatException {
        if (gameGame!=null) {
            if (gameGame.initialization){
                int ownIndex =-2;
                for (int i =0; i<game.talismansAct.length;i++){
                    if ((game.talismansAct[i].getClass() == this.getClass())){
                        ownIndex = i;
                    }
                }


                if (upgraded) {
                    int index23 =0;
                    for (TalismanA talisman : game.talismansAct) {
                        if (index23!=ownIndex){
                            if (talisman != null) {
                                talisman.TakeEffect();
    //     TODO                     BING BONG DING DONG nieskończna pętla tego typu benz
                            }
                        }
                        index23++;
                    }
                }else{
                    if (ownIndex >0 && ownIndex <7 && game.talismansAct[ownIndex-1]!=null &&game.talismansAct[ownIndex+1]!=null ){
                        game.talismansAct[ownIndex-1].TakeEffect();
                        game.talismansAct[ownIndex+1].TakeEffect();
                        System.out.println("2-21");
                    }else if (ownIndex==0 && game.talismansAct[1]!=null ){
                        game.talismansAct[1].TakeEffect();
                        System.out.println("2-21");
                    }else if (ownIndex==7 && game.talismansAct[6]!=null ){
                        game.talismansAct[6].TakeEffect();
                        System.out.println("2-21");
                    }
                }
            }

        }
    }
}
