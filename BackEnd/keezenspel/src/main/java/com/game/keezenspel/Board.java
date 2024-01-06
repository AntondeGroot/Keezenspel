package com.game.keezenspel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.game.keezenspel.Tiles.Tile;
import com.game.keezenspel.Tiles.Tiles;

public class Board {
    private List<Pawn> pawns = new ArrayList<Pawn>();
    private List<Integer> playerIds = new ArrayList<Integer>();

    public Board(int numberOfPlayers) {

        GeneratePlayerIDs(numberOfPlayers);

        Tiles tiles = new Tiles(playerIds);
        CreatePawns(tiles);
    }

    private void CreatePawns(Tiles tiles) {
        for (int playerId : playerIds) {
            List<Tile> nestTiles = tiles.findNestTiles(playerId);
            for (Tile nestTile : nestTiles) {
                pawns.add(new Pawn(playerId, nestTile));
            }
        }
    }

    private void GeneratePlayerIDs(int numberrofPlayer) {
        for (int i = 0; i < numberrofPlayer; i++) {
            playerIds.add(new Random().nextInt());
        }
    }

    public List<Pawn> getPawns() {
        return pawns;
    }
}
