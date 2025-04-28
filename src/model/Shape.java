package model;

import interfaces.Movable;

public abstract class Shape implements Movable {
    protected Color color;

    public abstract void draw();
    public abstract float getArea();

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
