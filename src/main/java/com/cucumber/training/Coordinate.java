package com.cucumber.training;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int xCoord, int yCoord) {
        x = xCoord;
        y = yCoord;
    }

    public int distanceFrom(Coordinate other) {
        return (int) Math.hypot(x - other.x, y - other.y);
    }
}
