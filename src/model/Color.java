package model;

public class Color {
    private int r;
    private int g;
    private int b;

    public Color(int r, int g, int b) {
        setColor(r, g, b);
    }

    public void setColor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static Color intWithValues(int r, int g, int b) {
        return new Color(r, g, b);
    }

    // Getters
    public int getR() { return r; }
    public int getG() { return g; }
    public int getB() { return b; }
}
