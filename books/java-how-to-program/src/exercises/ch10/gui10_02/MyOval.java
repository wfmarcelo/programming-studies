package ch10.gui10_02;

import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyBoundedShape {

    public MyOval() {
        super();
    }

    public MyOval(int x1, int y1, int x2, int y2, 
        Color color, boolean filled) {
            super(x1, y1, x2, y2, color, filled);
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
