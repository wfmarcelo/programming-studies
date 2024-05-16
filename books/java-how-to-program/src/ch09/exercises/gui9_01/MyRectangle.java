package ch09.exercises.gui9_01;

import java.awt.Color;
import java.awt.Graphics;

public class MyRectangle {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;
    private boolean filled;

    public MyRectangle() {
        setX1(0);
        setY1(0);
        setX2(0);
        setY2(0);
        setColor(Color.BLACK);
        setFilled(false);
    }

    public MyRectangle(int x1, int y1, int x2, int y2, 
        Color color, boolean filled) {
            setX1(x1);
            setY1(y1);
            setX2(x2);
            setY2(y2);
            setColor(color);
            setFilled(filled);
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

    public int getUpperLeftX() {
        return getX1()< getX2() ? getX1() : getX2();
    }

    public int getUpperLeftY() {
        return getY1() < getY2() ? getY1() : getY2();
    }

    public int getWidth() {
        return Math.abs(x1 - x2);
    }

    public int getHeight() {
        return Math.abs(y1 - y2);
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public void draw (Graphics g) {
        g.setColor(getColor());

        if (isFilled()) 
            g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        else
            g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
    }
    
}
