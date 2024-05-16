// Fig. 8.17: MyLine.java
// MyLine class represents a line
package ch10.exercises.gui10_01;

import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape {
    
    public MyLine() {
        super();    
    }

    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getX1(), getY1(), getX2(), getY2());
    }
}