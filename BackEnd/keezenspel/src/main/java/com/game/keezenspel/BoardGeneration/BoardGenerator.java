package com.game.keezenspel.BoardGeneration;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.geo.Point;

public class BoardGenerator {

public BoardGenerator() {
}
    // calculate first point
    int nrplayers = 2;
    int boardwidth = 600;
    int boardheight = boardwidth;
    int celldistance = 20;//cell diameter + distance 40+20

    double angle = 0;
    double angleAlfa = 0;
    List<BoardSection> quartiles = new ArrayList<>();
    List<String> points = new ArrayList<>();
    List<String> temppoints;
    BoardSection quartile;
    Point point;

    public BoardGenerator(int nrplayers, int boardwidth, int boardheight) {
        this.nrplayers = nrplayers;
        this.boardwidth = boardwidth;
        this.boardheight = boardheight;


        //calculate x distance
        double x = boardwidth/2 + 2*celldistance;
        double y = boardheight/2 + 2*celldistance*Math.tan(Math.toRadians(90-180/nrplayers));

        for (int i = 0; i < nrplayers; i++) {   
            this.quartile = new BoardSection(x, y, angle,celldistance);
            this.point = this.quartile.getLasPoint();
            
            x = point.getX();
            y = point.getY();
            temppoints = this.quartile.getAllPoints();
            for (String point : temppoints) {
                points.add(point);
            }
            angle -= 360/nrplayers;
        }

        for (String string : points) {
            System.out.println(string);
        }
    }

    @Override
    public String toString() {
        // System.out.println(this.quartile);
        return super.toString();
    }
    

    

    

    

}

