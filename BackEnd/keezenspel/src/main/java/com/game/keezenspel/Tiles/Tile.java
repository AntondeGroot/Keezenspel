package com.game.keezenspel.Tiles;

import java.util.Random;

import org.springframework.data.geo.Point;

public class Tile {
    private final long id;
    private final TileType tileType;
    private int playerId;
    private long previousTileId;
    private long nextTileId;
    private long nextFinishTileId;
    private Point point;

    public Tile(int playerId, TileType tileType, Point point) {
        id = new Random().nextLong();
        this.playerId = playerId;
        this.tileType = tileType;
        this.point = point;
    }

    public Point getPoint(){
        return this.point;
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

    public void connect(Tile other) {
        if (other.getType() == TileType.FINISH) {
            this.nextFinishTileId = other.getId();
            other.setPreviousTileId(this.id);
        } else {
            this.nextTileId = other.getId();
            other.setPreviousTileId(this.id);
        }
    }

    public TileType getType() {
        return this.tileType;
    }

    @Override
    public String toString() {
        return "\nTile [id: " + shortenId(id) + "\nplayerId:" + playerId + "\nTileType:" + tileType + "\npreviousId: "
                + shortenId(previousTileId) + "\nnextTileId: " + shortenId(nextTileId) + "\nnextHomeId: "
                + shortenId(nextFinishTileId) + "]\n";
    }

    private String shortenId(long number) {
        if (number == 0) {
            return "0";
        }
        String numberString = String.valueOf(number);
        return numberString.substring(numberString.length() - 3);
    }

}
