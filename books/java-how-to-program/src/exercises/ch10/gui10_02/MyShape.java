package ch10.gui10_02;

import java.awt.Color;
import java.awt.Graphics;

public abstract class MyShape {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;

    public MyShape() {
        
        setX1(0);
        setY1(0);
        setX2(0);
        setY2(0);
        setColor(Color.BLACK);
    }

    public MyShape(int x1, int y1, int x2, int y2, Color color) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setColor(color);
    }

    public void setX1(int x1) {
        if (x1 < 0)
            x1 = 0;
        this.x1 = x1;
    }

    public int getX1() {
        return x1;
    }

    public void setY1(int y1) {
        if (y1 < 0)
            y1 = 0;
        
        this.y1 = y1;
    }

    public int getY1() {
        return y1;
    }

    public void setX2(int x2) {
        if (x2 < 0)
            x2 = 0;
        this.x2 = x2;
    }

    public int getX2() {
        return x2;
    }

    public void setY2(int y2) {
        if (y2 < 0)
            y2 = 0;
        this.y2 = y2;
    }

    public int getY2() {
        return y2;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    public abstract void draw(Graphics g);
}
