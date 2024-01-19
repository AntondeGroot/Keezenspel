package com.game.keezenspel.BoardGeneration;

public class Cell {
    double x;
    double y;

    public Cell(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "<div class=\"cell\" style=\"top: "+( (y))+"px;left: "+(x)+"px;\" ></div>";
    }
}
