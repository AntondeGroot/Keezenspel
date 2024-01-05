package main.Tiles;

import java.util.Random;

public class Tile {
    protected long id;
    protected long previousTileId;
    protected long nextTileId;
    protected long nextHomeId;
    protected int playerId;
    protected boolean isPassable = true;
    protected boolean isSwappableByOther = true;
    protected boolean isSwappableBySelf = true;

    public Tile() {
        id = new Random().nextLong();
    }

    public void Connect(Tile other) {
        if (other.getClass() == FinishTile.class) {
            this.nextHomeId = other.id;
            other.previousTileId = this.id;
        } else {
            this.nextTileId = other.id;
            other.previousTileId = this.id;
        }
    }

    public boolean isSwappableByOther(long playerId) {
        if (this.playerId != playerId) {
            return true;
        }
        return this.isSwappableByOther;
    }

    public boolean isSwappableBySelf() {
        return this.isSwappableBySelf;
    }

    @Override
    public String toString() {
        return "Tile [id: " + id + "\n" +
                "previousId: " + previousTileId + "\n" +
                "nextTileId: " + nextTileId + "\n" +
                "nextHomeId: " + nextHomeId + "\n" +
                "isPassable: " + isPassable + "]\n\n";
    }

}
