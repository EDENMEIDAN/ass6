package interfaces;

import biuoop.DrawSurface;

/**
 * A interface of Sprites that can drawn on the screen, and can be notified that time has passed.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 06/05/2020
 */
public interface Sprite { //ball and block

    /**
     * this method draws the sprite on to the screen.
     *
     * @param d the draw surface on the screen to draw on.
     */
    void drawOn(DrawSurface d);

    /**
     * this method notify the sprite that time has passed.
     */
    void timePassed();
}