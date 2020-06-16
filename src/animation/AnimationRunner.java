package animation;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * this class represents an animation runner whick contains the main graphic loop of the whole game.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 11/06/20
 */

public class AnimationRunner {
    private int millisecondsPerFrame;
    private GUI gui;
    private Sleeper sleeper;

    /**
     * construct an animation runner from a given gui object.
     *
     * @param gui the game gui.
     * @param millisecondsPerFrame num of frames per second.
     */
    public AnimationRunner(GUI gui, int millisecondsPerFrame) {
        this.millisecondsPerFrame = millisecondsPerFrame;
        this.gui = gui;
        this.sleeper = new Sleeper();
    }

    /**
     * this method gets the gui.
     *
     * @return the gui.
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * @param animation the game
     */
    public void run(Animation animation) {
        System.out.println("animationRunner run");
        System.out.println(animation.shouldStop()); //should be false?//todo
        long newMillisecondsPerFrame = 1000 / this.millisecondsPerFrame;

        while (!animation.shouldStop()) {
            System.out.println("animationRunner in shouldStop while");
            DrawSurface d = this.gui.getDrawSurface();
            System.out.println("animationRunner run before doOneFrame");
            animation.doOneFrame(d); //!!!!!!!!!!!!
            System.out.println("animationRunner run after doOneFrame");
            this.gui.show(d);

            long startTime = System.currentTimeMillis(); // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}