package screens;

import animation.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * This class represents a pause screen object.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;

    /**
     * construct of a pause screen object that uses a keyboard sensor.
     *
     * @param k
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }

    /**
     * this method draws the frame of the animation of the pause screen and checks if SPACE key is pressed  to close it.
     *
     * @param d the DrawSurface to draw on.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.decode("#1e7f00"));
        d.fillRectangle(0, d.getHeight() / 2 - 160, d.getWidth(), 150);
        d.setColor(Color.GREEN);
        d.fillRectangle(0, d.getHeight() / 2 - 160, d.getWidth(), 3);
        d.drawText(290, d.getHeight() / 2 - 100, "Paused", 70);
        d.drawText(270, d.getHeight() / 2 - 30, "press space to continue", 25);
        d.fillRectangle(0, d.getHeight() / 2 - 10, d.getWidth(), 3);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
        return;
    }

    /**
     * this method checks if the animation drawing should be stopped.
     *
     * @return true if the animation drawing should stop, otherwise false.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}

