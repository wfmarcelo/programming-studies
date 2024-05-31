package ch10.gui10_01;

import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyShape {

    private boolean filled;

    public MyOval() {
        super();
    }

    public MyOval(int x1, int y1, int x2, int y2, 
        Color color, boolean filled) {
            super(x1, y1, x2, y2, color);
            setFilled(filled);
    }

    public int getUpperLeftX() {
        return getX1()< getX2() ? getX1() : getX2();
    }

    public int getUpperLeftY() {
        return getY1() < getY2() ? getY1() : getY2();
    }

    public int getWidth() {
        return Math.abs(getX1() - getX2());
    }

    public int getHeight() {
        return Math.abs(getY1() - getY2());
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public void draw (Graphics g) {
        g.setColor(getColor());

        if (isFilled()) 
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        else
            g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
    }
    
}
