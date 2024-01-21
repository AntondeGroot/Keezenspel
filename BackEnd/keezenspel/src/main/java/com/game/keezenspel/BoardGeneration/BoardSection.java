package com.game.keezenspel.BoardGeneration;

import java.lang.Math;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.geo.Point;

import com.game.keezenspel.Tiles.Tile;
import com.game.keezenspel.Tiles.TileType;

public class BoardSection {
    private long playerId;
    private double cellDistance;
    private double xpos;
    private double ypos;
    private Point startPoint;
    private double angleInRadians;
    private double angleInRadiansBackup;
    private List<Tile> tiles = new ArrayList<>();
    private List<Tile> nestTiles = new ArrayList<>();
    private List<Tile> finishTiles = new ArrayList<>();


    public BoardSection(long playerId, Point startPoint, double angleInDegrees, double cellDistance) {
        this.playerId = playerId;
        this.startPoint = startPoint;
        this.xpos = startPoint.getX();
        this.ypos = startPoint.getY();
        this.cellDistance = cellDistance;
        this.angleInRadians = Math.toRadians(angleInDegrees);
        this.angleInRadiansBackup = this.angleInRadians;

        createArmTiles();
        createFinishTiles();
        createNestTiles();
    }

    private void createNestTiles() {
        // determine starting point
        this.xpos = this.startPoint.getX();
        this.ypos = this.startPoint.getY();
        this.angleInRadians = this.angleInRadiansBackup;
        takeSingleStep(cellDistance*5);
        rotate(-90);
        takeSingleStep(cellDistance*5);

        // place tiles
        nestTiles.add(new Tile(this.playerId, TileType.FINISH, new Point(roundDouble(this.xpos), roundDouble(this.ypos))));
        
        rotate(45);
        takeSingleStep(this.cellDistance);
        nestTiles.add(new Tile(this.playerId, TileType.FINISH, new Point(roundDouble(this.xpos), roundDouble(this.ypos))));
        
        rotate(-90);
        takeSingleStep(this.cellDistance);
        nestTiles.add(new Tile(this.playerId, TileType.FINISH, new Point(roundDouble(this.xpos), roundDouble(this.ypos))));
        
        rotate(-90);
        takeSingleStep(this.cellDistance);
        nestTiles.add(new Tile(this.playerId, TileType.FINISH, new Point(roundDouble(this.xpos), roundDouble(this.ypos))));
    }

    private void createFinishTiles() {
        // determine starting point
        this.xpos = this.startPoint.getX();
        this.ypos = this.startPoint.getY();
        this.angleInRadians = this.angleInRadiansBackup;
        takeSingleStep(cellDistance*5);
        rotate(-90);
        takeSingleStep(cellDistance*2);
        rotate(-90);

        // place tiles
        for (int i = 0; i < 4; i++) {
            finishTiles.add(new Tile(this.playerId, TileType.FINISH, new Point(roundDouble(this.xpos), roundDouble(this.ypos))));
            takeSingleStep(this.cellDistance);
        }
    }

    private void createArmTiles() {
        createTiles(1, TileType.STARTCONSTRUCTION);
        createTiles(5, TileType.NORMAL);
        rotate(-90);
        createTiles(2, TileType.NORMAL);
        createTiles(1, TileType.LASTNORMAL);
        createTiles(1, TileType.START);
        rotate(-90);
        createTiles(5,TileType.NORMAL);
        createTiles(1,TileType.ENDCONSTRUCTION);
    }

    public Point getNextStartPoint() {
        // determine starting point
        this.xpos = this.startPoint.getX();
        this.ypos = this.startPoint.getY();
        this.angleInRadians = this.angleInRadiansBackup;
        rotate(-90);
        takeSingleStep(cellDistance*4);
        return new Point(this.xpos,this.ypos);
    }

    public List<Tile> getAllTiles() {
        return this.tiles;
    }

    private void createTiles(int numberOfTiles,TileType tileType) {
        for (int i = 0; i < numberOfTiles; i++) {
            tiles.add(new Tile(this.playerId, tileType, new Point(roundDouble(this.xpos), roundDouble(this.ypos))));
            takeSingleStep(this.cellDistance);
        }
    }

    private void takeSingleStep(double distance){
        this.xpos += Math.cos(this.angleInRadians) * distance;
        this.ypos -= Math.sin(this.angleInRadians) * distance;
    }

    private void rotate(double degrees) {
        this.angleInRadians += Math.toRadians(degrees);
    }

    private double roundDouble(double number){
        // configure formatting
        String roundedNumber = "";
        try {
            DecimalFormat df = new DecimalFormat("#,#####");
            df.setRoundingMode(RoundingMode.CEILING);
            
            // Formatting the double value
            roundedNumber = df.format(number);
        } catch (Exception NumberFormatException) {
            DecimalFormat df = new DecimalFormat("#.#####");
            df.setRoundingMode(RoundingMode.CEILING);
            
            // Formatting the double value
            roundedNumber = df.format(number);
        }

        // Converting the formatted string back to a double
        return Double.parseDouble(roundedNumber);
    }

}
