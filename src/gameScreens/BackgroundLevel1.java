package gameScreens;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/**
 * This class represents the background for the first level.
 */
public class BackgroundLevel1 implements Sprite {
    /**
     * this method draws the background on given DrawSurface.
     *
     * @param d the DrawSurface to draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.BLUE);
        d.drawCircle(400, 170, 45);
        d.drawCircle(400, 170, 85);
        d.drawCircle(400, 170, 130);
        d.drawLine(400, 0, 400, 140);
        d.drawLine(420, 170, 575, 170);
        d.drawLine(400, 195, 400, 330);
        d.drawLine(230, 170, 375, 170);
    }

    /**
     * this method notifies the background that a time unit has passed.
     */
    public void timePassed() {
    }
}
