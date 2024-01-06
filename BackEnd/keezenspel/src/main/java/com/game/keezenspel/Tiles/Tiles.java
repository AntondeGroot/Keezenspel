package com.game.keezenspel.Tiles;

import java.util.ArrayList;
import java.util.List;

import com.game.keezenspel.Pawn;

public class Tiles {
    private List<Tile> tiles = new ArrayList<Tile>();
    private List<Tile> nestTiles = new ArrayList<Tile>();
    
    public Tiles(int numberOfPlayers){
        int playerId = 1;

        CreateNestTiles(playerId);
        CreateStart(playerId);
        CreateNormalTiles();
        CreateFinishTiles(playerId);
        connectNormalAndFinishTiles();
        ConnectNestTiles();
    }

    private void CreateNestTiles(int playerId){
        for (int i = 0; i < 4; i++) {
            Tile nestTile = new Tile(playerId, TileType.NEST);
            nestTiles.add(nestTile);
        }
    }
    
    private void CreateStart(int playerId){
        tiles.add(new Tile(playerId, TileType.START));
    }

    private void CreateNormalTiles(){
        for(int i=1;i< 15; i++){
            tiles.add(new Tile(TileType.NORMAL));
        }
        tiles.add(new Tile(TileType.LASTNORMAL));
    }

    private void CreateFinishTiles(int playerId){
        for(int i=0;i< 4; i++){
            tiles.add(new Tile(playerId, TileType.FINISH));
        }
    }
    private void connectNormalAndFinishTiles(){
        for (int i = 0; i < tiles.size()-1; i++) {
            tiles.get(i).connect(tiles.get(i+1));
        }
    }

    private void ConnectNestTiles(){
        for (Tile nesttile : nestTiles) {
            nesttile.connect(tiles.get(0));
            tiles.add(nesttile);
        }
    }
}
