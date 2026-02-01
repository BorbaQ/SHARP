package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

public abstract class TalismanA {
    public Game game;
    public GameGame gameGame;
    public Boolean upgraded;
    public boolean initial = false;
    public int power = -2;
    protected TalismanA(Game gameContext, GameGame gameGameContext) {
        game = gameContext;
        gameGame = gameGameContext;
        power = 1;
        upgraded = false;
    }
    abstract public void handleUpgrade();

    protected TalismanA() {
    }

    abstract public void TakeEffect();
}
