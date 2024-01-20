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
    private double cellDistance;
    private double xpos;
    private double ypos;
    private double angleInRadians;
    private Point lastNormalPoint;
    private List<Tile> tiles = new ArrayList<>();
    private Point firstCorner;
    private Point secondCorner;
    private Point thirdCorner;
    private Point fourthCorner;

    public BoardSection(Point startPoint, double angleInDegrees, double cellDistance) {

        this.firstCorner = startPoint;

        this.xpos = startPoint.getX();
        this.ypos = startPoint.getY();
        this.cellDistance = cellDistance;
        this.angleInRadians = Math.toRadians(angleInDegrees);

        createNTiles(1, TileType.STARTCONSTRUCTION);
        secondCorner = createNTiles(5, TileType.NORMAL);
        rotate(-90);
        createNTiles(1, TileType.NORMAL);
        this.lastNormalPoint = createNTiles(1, TileType.LASTNORMAL);
        // draw homebase
        rotateAndExtend(-90, this.cellDistance);
        createNTiles(4,TileType.FINISH);
        // reset
        this.xpos = this.lastNormalPoint.getX();
        this.ypos = this.lastNormalPoint.getY();
        rotate(-270);
        // continue
        createNTiles(1, TileType.START);
        this.lastNormalPoint = createNTiles(1, TileType.NORMAL);
        // draw nest       
        drawBase();
        // rest of tiles
        this.xpos = this.lastNormalPoint.getX();
        this.ypos = this.lastNormalPoint.getY();
        createNTiles(5,TileType.NORMAL);
        createNTiles(1,TileType.ENDCONSTRUCTION);

        
    }

    public Point getNextStartPoint() {
        return new Point(this.xpos,this.ypos);
    }

    public List<Tile> getAllTiles() {
        return this.tiles;
    }

    private Point createNTiles(int steps,TileType tileType) {
        for (int i = 0; i < steps; i++) {
            tiles.add(new Tile(0, tileType, new Point(roundDouble(this.xpos), roundDouble(this.ypos))));
            takeSingleStep(this.cellDistance);
        }
        return new Point(this.xpos, this.ypos);
    }

    // private void takeNSteps(double distance,int steps){
    //     for (int i = 0; i < steps; i++) {
    //         this.xpos += Math.cos(this.angleInRadians) * distance;
    //         this.ypos += Math.sin(this.angleInRadians) * distance;
    //     }
    // }

    private void takeSingleStep(double distance){
        this.xpos += Math.cos(this.angleInRadians) * distance;
        this.ypos -= Math.sin(this.angleInRadians) * distance;
    }

    private void rotate(double degrees) {
        this.angleInRadians += Math.toRadians(degrees);
    }
    private void rotateAndExtend(double degrees, double stepsize){
        rotate(degrees);
        takeSingleStep(stepsize);
    }
    private void drawBase(){
        takeSingleStep(this.cellDistance*3);

        
        tiles.add(new Tile(0, TileType.FINISH, new Point(roundDouble(this.xpos), roundDouble(this.ypos))));
        rotate(-90);

        takeSingleStep(this.cellDistance);
        tiles.add(new Tile(0, TileType.FINISH, new Point(roundDouble(this.xpos), roundDouble(this.ypos))));
        rotate(-90);

        takeSingleStep(this.cellDistance);
        tiles.add(new Tile(0, TileType.FINISH, new Point(roundDouble(this.xpos), roundDouble(this.ypos))));
        rotate(-90);

        takeSingleStep(this.cellDistance);
        tiles.add(new Tile(0, TileType.FINISH, new Point(roundDouble(this.xpos), roundDouble(this.ypos))));
        rotate(-180);
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
