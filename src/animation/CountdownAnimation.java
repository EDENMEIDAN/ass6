package animation;

import biuoop.DrawSurface;
import settings.SpriteCollection;

import java.awt.Color;

/**
 * this class represents a count down animation object.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since 16/06/20
 */
public class CountdownAnimation implements Animation {
    private boolean running;
    private long numOfMillis;
    private long initiationTime;
    private int countFrom;
    private int initialCount;
    private SpriteCollection gameScreen;


    /**
     * construct a count down animation object from the time of annicalize the the animation run,
     * number to count down from, and the game's sprite screen.
     *
     * @param numOfSeconds time of displaying the count down animation.
     * @param countFrom the number to count down from.
     * @param gameScreen the game's sprites.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.running = true;
        this.numOfMillis = (long) (numOfSeconds * 1000);
        this.countFrom = countFrom;
        this.initialCount = countFrom;
        this.gameScreen = gameScreen;
        this.initiationTime = System.currentTimeMillis();
    }

    /**
     * this method draws each frame of the animation of the count down animation on a given DrawSurface.
     * when count down reaches 0 it changes the running member to false, so the animation will stop.
     *
     * @param d the DrawSurface to draw on.
     */
    public void doOneFrame(DrawSurface d) {
        //System.out.println("CountdownAnimation doOneFrame");
        if (this.countFrom == 0) {
            this.running = false;
        }
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.white);
        d.drawText(385, 450, Integer.toString(this.countFrom), 65);
        if (System.currentTimeMillis() - this.initiationTime > this.numOfMillis / this.initialCount) {
            this.initiationTime = System.currentTimeMillis();
            this.countFrom--;
        }
    }

    /**
     * this method returns true if count down animation has to stop, false otherwise.
     *
     * @return true if count down animation has to stop, false otherwise.
     */
    public boolean shouldStop() {
        return !this.running;
    }
}