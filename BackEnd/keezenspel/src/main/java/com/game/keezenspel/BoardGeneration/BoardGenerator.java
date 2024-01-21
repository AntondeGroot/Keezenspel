package com.game.keezenspel.BoardGeneration;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.geo.Point;

import com.game.keezenspel.Tiles.Tile;

public class BoardGenerator {
    private double celldistance;
    private double angle = -90;
    private List<BoardSection> boardSections = new ArrayList<>();
    private BoardSection boardSection;
    private List<Tile> tiles = new ArrayList<Tile>();
    private Point nextStartPoint;
    private int nrPlayers;

    public BoardGenerator(int nrplayers, int boardwidth) {
        this.celldistance = BoardSize.getCellDistance(nrplayers, boardwidth);
        this.nrPlayers = nrplayers;

        calculateStartingOffset(boardwidth, this.nrPlayers);

        for (int i = 0; i < nrplayers; i++) {
            createBoardSection(i);
            appendTiles();
            rotateStartingAngle();
        }
    }

    public void printOutDIVs() {
        String divClassName; 
        for (Tile tile : tiles) {          
            switch (tile.getType()){
                case NEST:
                case FINISH:
                case START:
                    divClassName = "playercell";
                    break;
                default:
                    divClassName = "cell";
                    break;
            }
            System.out.println("<div class=\""+divClassName+"\" style=\"top: " + (tile.getPoint().getY()) + "px;left: " + (tile.getPoint().getX()) + "px;\" ></div>");
        }
    }

    private void appendTiles() {
        List<Tile> localTiles = new ArrayList<>();
        localTiles = this.boardSection.getAllTiles();
        for (Tile tile : localTiles) {
            tiles.add(tile);
        }
    }

    private void createBoardSection(long playerId) {
        boardSection = new BoardSection(playerId, nextStartPoint, angle, celldistance);
        nextStartPoint = boardSection.getNextStartPoint();
        boardSections.add(boardSection);
    }

    private void calculateStartingOffset(double boardwidth, int nrplayers) {
        this.nextStartPoint = new Point(
                boardwidth / 2 + 2 * celldistance,
                boardwidth / 2 + 2 * celldistance * Math.tan(Math.toRadians(90 - 180 / nrplayers)));
    }

    private void rotateStartingAngle() {
        this.angle -= 360 / this.nrPlayers;
    }
}
