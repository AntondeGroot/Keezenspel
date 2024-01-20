// package com.game.keezenspel.Tiles;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.stream.Collectors;

// public class Tiles {
//     private List<Tile> tiles = new ArrayList<Tile>();
//     private List<Tile> tempNestTiles = new ArrayList<Tile>();
//     private List<Tile> tempTiles = new ArrayList<Tile>();

//     public Tiles(List<Integer> playerIds) {

//         for (int playerId : playerIds) {
//             tempTiles = new ArrayList<Tile>();
//             tempNestTiles = new ArrayList<Tile>();

//             CreateNestTiles(playerId);
//             CreateStartTile(playerId);
//             CreateNormalTiles(playerId);
//             CreateFinishTiles(playerId);

//             connectNormalAndFinishTiles();
//             ConnectNestTiles();

//             for (Tile tempTile : tempTiles) {
//                 tiles.add(tempTile);
//             }

//         }
//         connectFirstAndLastTiles(playerIds);
//         System.err.println(tiles);
//     }

//     private void connectFirstAndLastTiles(List<Integer> playerIds) {
//         for (int i = 0; i < playerIds.size(); i++) {
//             int playerId = playerIds.get(i);
//             int nextPlayerId;

//             if (playerIds.get(i) == playerIds.getLast()) {
//                 nextPlayerId = playerIds.get(0);
//             } else {
//                 nextPlayerId = playerIds.get(i + 1);
//             }

//             Tile lastTile = findTile(playerId, TileType.LASTNORMAL);
//             Tile firstTile = findTile(nextPlayerId, TileType.START);
//             lastTile.connect(firstTile);
//         }
//     }

//     public Tile findTile(int playerId, TileType tileType) {
//         Tile foundTile = new Tile(0, TileType.NORMAL);

//         try {
//             foundTile = tiles.stream()
//                     .filter(tile -> (tile.getPlayerId() == playerId))
//                     .filter(tile -> tile.getType() == tileType)
//                     .findFirst()
//                     .orElseThrow(
//                             () -> new Error("Tile was not found for player: " + playerId + " tileType: " + tileType));

//             return foundTile;
//         } catch (Exception e) {
//         }

//         return foundTile;
//     }

//     public Tile findTile(long tileId) {
//         Tile foundTile = new Tile(0, TileType.NORMAL);

//         try {
//             foundTile = tiles.stream()
//                     .filter(tile -> (tile.getId() == tileId))
//                     .findFirst()
//                     .orElseThrow(() -> new Error("Tile was not found for tileId: " + tileId));

//             return foundTile;
//         } catch (Exception e) {
//         }

//         return foundTile;
//     }

//     public List<Tile> findNestTiles(int playerId) {
//         List<Tile> foundTiles = tiles.stream()
//                 .filter(tile -> (tile.getPlayerId() == playerId))
//                 .filter(tile -> (tile.getType() == TileType.NEST))
//                 .collect(Collectors.toList());

//         return foundTiles;
//     }

//     private void CreateNestTiles(int playerId) {
//         for (int i = 0; i < 4; i++) {
//             Tile nestTile = new Tile(playerId, TileType.NEST);
//             tempNestTiles.add(nestTile);
//         }
//     }

//     private void CreateStartTile(int playerId) {
//         tempTiles.add(new Tile(playerId, TileType.START));
//     }

//     private void CreateNormalTiles(int playerId) {
//         for (int i = 1; i < 15; i++) {
//             tempTiles.add(new Tile(playerId, TileType.NORMAL));
//         }
//         tempTiles.add(new Tile(playerId, TileType.LASTNORMAL));
//     }

//     private void CreateNormalTile(int playerId) {
//         for (int i = 1; i < 15; i++) {
//             tempTiles.add(new Tile(playerId, TileType.NORMAL));
//         }
//         tempTiles.add(new Tile(playerId, TileType.LASTNORMAL));
//     }

//     private void CreateFinishTiles(int playerId) {
//         for (int i = 0; i < 4; i++) {
//             tempTiles.add(new Tile(playerId, TileType.FINISH));
//         }
//     }

//     private void connectNormalAndFinishTiles() {
//         for (int i = 0; i < tempTiles.size() - 1; i++) {
//             tempTiles.get(i).connect(tempTiles.get(i + 1));
//         }
//     }

//     private void ConnectNestTiles() {
//         for (Tile nesttile : tempNestTiles) {
//             nesttile.connect(tempTiles.get(0));
//             tempTiles.add(nesttile);
//         }
//     }

//     public List<Tile> getTiles() {
//         return this.tiles;
//     }
// }
