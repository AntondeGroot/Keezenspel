package main.Tiles;
public class NestTile extends Tile {
    
    public NestTile(int playerId){
        this.playerId = playerId;
        this.isSwappableByOther = false;
        this.isSwappableBySelf = false;
    }
    
    @Override
    public void Connect(Tile otherTile){
        this.nextTileId = otherTile.id;
    }
}
