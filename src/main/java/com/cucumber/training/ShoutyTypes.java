package com.cucumber.training;

class PersonLocation {
    String name;
    int x;
    int y;

    public PersonLocation(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public Coordinate getLocation() {
        return new Coordinate(x, y);
    }
}

