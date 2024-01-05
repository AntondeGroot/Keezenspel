package main.Tiles;

public class StartTile extends Tile {
    public StartTile(int playerId) {
        this.playerId = playerId;
        this.isPassable = false;
        this.isSwappableByOther = false;     
        this.isSwappableBySelf = true; 
    }
}

