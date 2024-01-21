package com.game.keezenspel.BoardGeneration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.data.geo.Point;

import com.game.keezenspel.Tiles.Tile;
import com.game.keezenspel.Tiles.TileType;

public class BoardSectionTest {
    @Test
    void firstGeneratedPointIsAtStartPoint() {
        // [GIVEN]
        Point startPoint = new Point(0,0);

        // [WHEN]
        BoardSection boardSection = new BoardSection(0,startPoint,-90, 20);
        List<Tile> tiles = boardSection.getAllTiles();
        Tile tile = tiles.getFirst();

        // [THEN]
        assertEquals(startPoint,tile.getPoint(), "should be startpoint");
    }

    @Test
    void secondGeneratedPointIsBelowStartPoint() {
        // [GIVEN]
        Point startPoint = new Point(0,0);

        // [WHEN]
        BoardSection boardSection = new BoardSection(0, startPoint,-90, 20);
        List<Tile> tiles = boardSection.getAllTiles();
        Tile tile = tiles.getFirst();
        Tile secondTile = tiles.get(1);
        Tile thirdTile = tiles.get(2);

        // [THEN]
        assertTrue(tile.getPoint().getY() < secondTile.getPoint().getY(),"second tile should be below the startpoint");
        assertTrue(secondTile.getPoint().getY() < thirdTile.getPoint().getY(),"third tile should be below the second tile");
        // assertEquals(secondTile.getPoint().getX(), thirdTile.getPoint().getX(),"second tile should have the same x coordinate");
        assertTrue(tile.getType()==TileType.STARTCONSTRUCTION,"");
        assertTrue(secondTile.getType()==TileType.NORMAL,"");
        assertEquals((int)tile.getPoint().getX(), (int)secondTile.getPoint().getX(),"second tile should have the same x coordinate");
    }

    @Test
    void pointAfterFirstCornerIsToTheLeftOfCorner() {
        // [GIVEN]
        Point startPoint = new Point(0,0);

        // [WHEN]
        BoardSection boardSection = new BoardSection(0, startPoint,-90, 20);
        List<Tile> tiles = boardSection.getAllTiles();
        Tile cornerTile = tiles.get(6);
        Tile testTile = tiles.get(7);

        // [THEN]
        assertTrue(testTile.getPoint().getX() < cornerTile.getPoint().getX(),"second tile should be to the left of the corner tile");
        assertEquals((int)cornerTile.getPoint().getY(), (int)testTile.getPoint().getY(),"tile after the corner should have the same y coordinate");
    }
}
