package MainMenu.Talismans;

import MainMenu.Game;
import MainMenu.GameGame;

public abstract class TalismanA {
    public Game game;
    public GameGame gameGame;
    public Boolean upgraded;
    public Boolean Finisher;
    public int power = -2;
    protected TalismanA(Game gameContext, GameGame gameGameContext) {
        game = gameContext;
        gameGame = gameGameContext;
        power = 10;

    }
    abstract public void handleUpgrade();

    protected TalismanA() {
    }

    abstract public void TakeEffect();
}
