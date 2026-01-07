package MainMenu.Talismans;

public class T1x0 extends TalismanA{
    T1x0(){
        super();
        Finisher = false;
        power = 1;
    }
    @Override
    public void handleUpgrade() {
        upgraded = true;
    }

    @Override
    public void TakeEffect() {
        if (upgraded){
            while(true) {
                int tile = game.deck.getRandomTileNR();
                if (!game.SoulTiles.contains(tile)){
                    game.addSoulTile();
                }
            }
        }

    }
}
