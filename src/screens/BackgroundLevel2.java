package screens;

import biuoop.DrawSurface;
import interfaces.Sprite;
import settings.Const;
import sprites.Block;

import java.awt.Color;

/**
 * This class represents the background for the second level.
 */
public class BackgroundLevel2 implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        int widthMid = 100;
        int heightMid = 150;
        // set backround to white
        Block block = new Block(0, 0, Const.getScreenWidth(), Const.getPaddleHeight(),
                new Color(223, 212, 224), 1);
        block.drawOn(d);

        // draw lines
        d.setColor(new Color(237, 226, 141));
        for (int i = 0; i < 100; i++) {
            d.drawLine(90, 140, 11 * i, 300);
        }
        // inner circal
        d.fillCircle(widthMid, heightMid, 60);

        // mid circal
        d.setColor(new Color(242, 199, 76));
        d.fillCircle(widthMid, heightMid, 45);

        // outter circal
        d.setColor(new Color(230, 204, 120));
        d.fillCircle(widthMid, heightMid, 35);
    }

    @Override
    public void timePassed() {
    }
}