package screens;

import biuoop.DrawSurface;
import interfaces.Sprite;
import settings.Const;

import java.awt.Color;


/**
 * This class represents the background for the third level.
 */
public class BackgroundLevel3 implements Sprite {

    @Override
    public void drawOn(DrawSurface d) {
        //green background
        d.setColor(Color.GREEN.darker());
        d.fillRectangle(0, 0, Const.getScreenWidth(), Const.getScreenHight());

        d.setColor(Color.DARK_GRAY);
        d.fillRectangle(145, 180, 10, 240);
        d.fillRectangle(135, 410, 30, 40);

        //outter antenna cercal
        d.setColor(Color.ORANGE);
        d.fillCircle(150, 180, 10);

        //midlle antenna circal
        d.setColor(Color.RED);
        d.fillCircle(150, 180, 7);

        //inner antenna circal
        d.setColor(Color.WHITE);
        d.fillCircle(150, 180, 3);

        //roof
        d.setColor(Color.DARK_GRAY.darker());
        d.fillRectangle(100, 450, 100, 150);

        // create windows
        d.setColor(Color.WHITE);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(110 + 18 * i, 460 + 30 * j, 10, 25);
            }
        }
    }


    public void timePassed() {

    }

}
