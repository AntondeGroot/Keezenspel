package com.game.keezenspel.BoardGeneration;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.geo.Point;

import com.game.keezenspel.Tiles.Tile;

public class BoardGenerator {
    private int celldistance = 20;
    private double angle = -90;
    private List<BoardSection> boardSections = new ArrayList<>();
    private BoardSection boardSection;
    private List<Tile> tiles = new ArrayList<Tile>();
    private Point nextStartPoint;
    private int nrPlayers;

    public BoardGenerator(int nrplayers, int boardwidth) {
        this.nrPlayers = nrplayers;

        calculateStartingOffset(boardwidth, this.nrPlayers);

        for (int i = 0; i < nrplayers; i++) {
            createBoardSection();
            appendTiles();
            rotateStartingAngle();
        }
        connectAllSections();
    }

    private void appendTiles(){
        List<Tile>localTiles = new ArrayList<>();
         localTiles = this.boardSection.getAllTiles();
         for (Tile tile : localTiles) {
            tiles.add(tile);
         }

    }


    private void createBoardSection() {
        boardSection = new BoardSection(nextStartPoint, angle, celldistance);
        nextStartPoint = boardSection.getNextStartPoint();
        boardSections.add(boardSection);
    }

    private void connectAllSections() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'connectAllTiles'");
    }

    public void calculateStartingOffset(double boardwidth, int nrplayers) {
        this.nextStartPoint = new Point(
                boardwidth / 2 + 2 * celldistance,
                boardwidth / 2 + 2 * celldistance * Math.tan(Math.toRadians(90 - 180 / nrplayers)));
    }

    public void printOutDIVs() {
        for (Tile tile : tiles) {
            System.out.println("<div class=\"cell\" style=\"top: " + (tile.getPoint().getY()) + "px;left: " + (tile.getPoint().getX()) + "px;\" ></div>");
        }
    }

    public void rotateStartingAngle() {
        this.angle -= 360 / this.nrPlayers;
    }

    public void appendPoints() {

    }
}
