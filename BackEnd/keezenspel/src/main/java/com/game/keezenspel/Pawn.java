package com.game.keezenspel;

import java.util.List;
import java.util.Random;

import com.game.keezenspel.Tiles.Tile;

public class Pawn {
    private long id;
    private int playerId;
    private Tile positionTile; 
    private Tile homeTile;

    public Pawn(int playerId, Tile nestTile){
        this.id = new Random().nextLong();
        this.playerId = playerId;
        this.homeTile = nestTile;
        this.positionTile = nestTile;
    }

    public long getId() {
        return id;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void kill(){
        this.positionTile = this.homeTile;
    }

    public void move(List<Tile> tiles){

    }
   

    public void SwapWith(Pawn otherPawn){
            Tile tempTile = otherPawn.positionTile;
            otherPawn.positionTile = this.positionTile;
            this.positionTile = tempTile;
    }

    public void CanMove(){}
    public void Move(){}

}
