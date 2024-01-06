package com.game.keezenspel.Tiles;

import java.util.Random;

public class Tile {
    private final long id;
    private final TileType tileType;
    private int playerId;
    private long previousTileId;
    private long nextTileId;
    private long nextFinishTileId;

public Tile(int playerId, TileType tileType){
        id = new Random().nextLong();
        this.playerId = playerId;
        this.tileType = tileType;
    }

    public Tile(TileType tileType){
        id = new Random().nextLong();
        this.tileType = tileType;
    }

    public long getId() {
        return id;
    }

    public long getPreviousTileId() {
        return previousTileId;
    }

    public long getNextTileId() {
        return nextTileId;
    }

    public long getNextFinishTileId() {
        return nextFinishTileId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPreviousTileId(long previousTileId) {
        this.previousTileId = previousTileId;
    }

    public void connect(Tile other){
        if(other.getType() == TileType.FINISH){
            this.nextFinishTileId = other.getId();
            other.setPreviousTileId(this.id);
        }else{
            this.nextTileId = other.getId();
            other.setPreviousTileId(this.id);
        }
    }

    public TileType getType(){
        return this.tileType;
    }

    @Override
    public String toString() {
        return "Tile [id: " + id + "\npreviousId: " + previousTileId + "\nnextTileId: " + nextTileId + "\nnextHomeId: " + nextFinishTileId + "]\n\n";
    }

}
