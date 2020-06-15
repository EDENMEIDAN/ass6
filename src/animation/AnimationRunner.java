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
     * @param gui
     */
    public AnimationRunner(GUI gui) {
        this.millisecondsPerFrame = 60;
        this.gui = new GUI("Arkanoid", 800, 600);
        this.sleeper = new Sleeper();
        //this.dt = 1 / (double) millisecondsPerFrame;
    }

    public AnimationRunner() {
        this.millisecondsPerFrame = 60;
        this.gui = new GUI("Arkanoid", 800, 600);
        this.sleeper = new Sleeper();
        //this.dt = 1 / (double) millisecondsPerFrame;
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
        int newMillisecondsPerFrame = 1000 / this.millisecondsPerFrame;

        while (!animation.shouldStop()) {
            System.out.println(999);
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            this.gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = newMillisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}