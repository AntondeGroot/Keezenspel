package com.game.keezenspel.BoardGeneration;

import org.springframework.data.geo.Point;

public class BoardSize {
    
    public static double getCellDistance(int nrplayers, double boardSize){
        // length from center to bottom of first boardsection is equal to: 
        // 2 * celldistance * Math.tan(Math.toRadians(90 - 180 / nrplayers)) + 6*celldistance;
        double padding = 50;
        
        double fx = Math.tan(Math.toRadians(90 - 180 / nrplayers)); 
        double availableRadius = boardSize/2-padding;
        double celldistance = availableRadius/(6+2*fx);

        return celldistance;
    }

}
