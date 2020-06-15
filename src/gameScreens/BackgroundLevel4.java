package gameScreens;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.awt.Color;

/**
 * This class represents the background for the forth level.
 */
public class BackgroundLevel4 implements Sprite {
    /**
     * this method draws the sprite on to the screen.
     *
     * @param d the draw surface on the screen to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        //blue background
        d.setColor(Color.blue.brighter());
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());

        //4 dark gray cloud circles
        d.setColor(Color.LIGHT_GRAY);
        d.fillCircle(175, 430, 30);
        d.fillCircle(160, 400, 25);
        d.fillCircle(625, 480, 30);
        d.fillCircle(610, 450, 25);

        //2 mid-dark gray cloud circles
        d.setColor(Color.GRAY.brighter());
        d.fillCircle(200, 395, 25);
        d.fillCircle(650, 445, 25);

        //4 light gray cloud circles
        d.setColor(Color.GRAY);
        d.fillCircle(230, 400, 30);
        d.fillCircle(215, 425, 20);
        d.fillCircle(680, 450, 30);
        d.fillCircle(665, 475, 20);

        // 10 white rain lines
        d.setColor(Color.WHITE);
        for (int i = 0; i < 10; i++) {
            d.drawLine(150 + 10 * i, 410, 110 + 10 * i, 600);
        }
        // 10 white rain lines
        for (int i = 0; i < 10; i++) {
            d.drawLine(600 + 10 * i, 450, 560 + 10 * i, 600);
        }
    }

    /**
     * this method notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

    }
}
