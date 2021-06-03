package app.paint.shape;

import java.awt.*;

public abstract class PaintShape {

    static final int DEFAULT_LENGTH = 10;

    private int x;
    private int y;
    private Color color;
    private int width = DEFAULT_LENGTH;
    private int height = DEFAULT_LENGTH;

    public PaintShape(int x, int y, Color color){
        this(x, y, DEFAULT_LENGTH, DEFAULT_LENGTH, color);
    }

    public PaintShape(int x, int y, int width, int height, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public abstract Shape createShape();


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}