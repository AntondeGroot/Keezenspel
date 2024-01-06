package com.game.keezenspel;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.game.keezenspel.Tiles.Tile;
import com.game.keezenspel.Tiles.TileType;
import com.game.keezenspel.Tiles.Tiles;

public class TilesTest {

    @Test
    public void Test_BoardHasEnoughTiles() {
        // [GIVEN]
        List<Integer> playerIds = Arrays.asList(1, 2, 3, 4);
        int tilesPerPlayer = 24;
        int totalTiles = playerIds.size() * tilesPerPlayer;

        // [WHEN]
        Tiles tiles = new Tiles(playerIds);

        // [THEN]
        assertEquals(totalTiles, tiles.getTiles().size(),
                "There should be 4 Nest tiles, 1 Start tile, 15 Normal tiles and 4 Finish tiles per player");
    }

    @Test
    public void Test_AllNormalTilesAndStartTilesAreForwardsConnected() {
        // [GIVEN]
        List<Integer> playerIds = Arrays.asList(1, 2, 3, 4);
        int tilesPerPlayer = 16;
        Tiles tiles = new Tiles(playerIds);

        // [WHEN]
        // start with player 1's Start tile
        Tile startTile = tiles.findTile(1, TileType.START);
        long startId = startTile.getId();
        long nextId = startTile.getNextTileId();
        // continue looking for the next connected tile
        for (int i = 1; i < tilesPerPlayer*playerIds.size(); i++) {
            Tile tile = tiles.findTile(nextId);
            nextId = tile.getNextTileId();
        }

        // [THEN]
        assertEquals(startId, nextId, "when you loop around the start id should be the same as the last nextid");
    }

    @Test
    public void Test_AllNormalTilesAndStartTilesAreBackwardsConnected() {
        // [GIVEN]
        List<Integer> playerIds = Arrays.asList(1, 2, 3, 4);
        int tilesPerPlayer = 16;
        Tiles tiles = new Tiles(playerIds);

        // [WHEN]
        // start with player 1's Start tile
        Tile startTile = tiles.findTile(1, TileType.START);
        long startId = startTile.getId();
        long nextId = startTile.getPreviousTileId();
        // continue looking for the next connected tile
        for (int i = 1; i < tilesPerPlayer*playerIds.size(); i++) {
            Tile tile = tiles.findTile(nextId);
            nextId = tile.getPreviousTileId();
        }

        // [THEN]
        assertEquals(startId, nextId, "when you loop around the start id should be the same as the last nextid");
    }
}
