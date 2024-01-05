package main.Tiles;
public class FinishTile extends Tile {
    public FinishTile(int playerId) {
        this.playerId = playerId;
        this.isPassable = false;
        this.isSwappableByOther = false;     
        this.isSwappableBySelf = false; 
    }
}
