package com.game.keezenspel.BoardGeneration;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.geo.Point;

public class BoardSection {
    private double width;
    private double height;
    private Point point;
    private double cellDistance;

    private double angleInDegrees;
    private double xpos;
        private double ypos;
        private double angleInRadians;

    List<Cell> cells = new ArrayList<Cell>();

    public BoardSection(double Xstart, double Ystart, double angleInDegrees, double cellDistance) {
        this.xpos = Xstart;
        this.ypos = Ystart;
        this.cellDistance = cellDistance;
        this.angleInDegrees = angleInDegrees;
        this.angleInRadians = Math.toRadians(angleInDegrees);
        Point lastPoint;
        Point nextPoint;

        // loop down from starting point
        
        for (int i = 0; i < 6; i++) {
            cells.add(new Cell(xpos, ypos));
            xpos += Math.sin(Math.toRadians(angleInDegrees)) * cellDistance;
            ypos += Math.cos(Math.toRadians(angleInDegrees)) * cellDistance;
        }
        // make 90 degree turn
        for (int i = 0; i < 4; i++) {
            cells.add(new Cell(xpos, ypos));
            xpos += Math.sin(Math.toRadians(angleInDegrees - 90)) * cellDistance;
            ypos += Math.cos(Math.toRadians(angleInDegrees - 90)) * cellDistance;
            //2 = turn to home
            if (i==2) {

            }
            //3 = startpoint
        }
        // loop back
        for (int i = 0; i < 6; i++) {
            cells.add(new Cell(xpos, ypos));
            xpos += Math.sin(Math.toRadians(angleInDegrees - 180)) * cellDistance;
            ypos += Math.cos(Math.toRadians(angleInDegrees - 180)) * cellDistance;
        }
        this.point = new Point(xpos, ypos);

        // takeSteps(6);
        //     makeTurn(90);
        //     nextPoint = takeSteps(3);
        //     makeTurn(90);
        //     //draw homebase
        //     takeSteps(4);
        //     //reset
        //     this.xpos = nextPoint.getX();
        //     this.ypos = nextPoint.getY();
        //     makeTurn(270);
        //     // continue
        //     takeSteps(2);
        //     makeTurn(90);
        //     takeSteps(6);
    }

    public Point getLasPoint() {
        return this.point;
    }

    @Override
    public String toString() {
        for (Cell cell : cells) {
            System.out.println(cell);
        }
        return "";
    }

    public List<String> getAllPoints() {
        List<String> points = new ArrayList<>();

        for (Cell cell : cells) {
            points.add(cell.toString());
        }

        return points;
    }

    private Point takeSteps(int steps){
        for (int i = 0; i < 6; i++) {
            cells.add(new Cell(this.xpos, this.ypos));
            this.xpos += Math.sin(Math.toRadians(this.angleInDegrees)) * this.cellDistance;
            this.ypos += Math.cos(Math.toRadians(angleInDegrees)) * this.cellDistance;
        }
        return new Point(this.xpos,this.ypos);
    }
    private void makeTurn(double degrees){
        this.angleInDegrees += degrees; 
    }

}
