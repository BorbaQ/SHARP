package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;
import MainMenu.Main;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class T1_57 extends TalismanA{
    public T1_57(Game gameContext, GameGame gameGameContext) {
        super(gameContext, gameGameContext);
        upgraded = false;
        power = 0;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }
    Random rand = new Random();
    @Override
    public void TakeEffect() throws IOException, FontFormatException {
        if (gameGame!=null) {
            if (gameGame.initialization){
                for (int i = 0;i < gameGame.TileWallArray.size();i++){
                    if (!Main.mainWindow.game.DoraTiles.isEmpty()) {
                        for (int k = 0; k < Main.mainWindow.game.DoraTiles.size(); k++) {
                            if (Main.mainWindow.game.DoraTiles.get(k)%10==9) {
                                if (Objects.equals((Main.mainWindow.game.DoraTiles.get(k)/10*10)+1, gameGame.TileWallArray.get(i))){
                                    if (upgraded){
                                        power+=3;
                                    }else{
                                        power   +=2;
                                    }
                                    break;
                                }
                            }else if (Objects.equals(Main.mainWindow.game.DoraTiles.get(k)+1, gameGame.TileWallArray.get(i))) {
                                if (upgraded){
                                    power+=3;
                                }else{
                                    power   +=2;
                                }
                                break;
                            }
                        }
                    }
                }
            }
            if (gameGame.isWinning){
                gameGame.han*= power;
            }
        }
    }
}
