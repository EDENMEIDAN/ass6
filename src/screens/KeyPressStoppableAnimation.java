package screens;

import animation.Animation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * this class is an KeyPressStoppableAnimation object that that stops animations.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String key;
    private Animation animation;
    private boolean closeScreen;
    private boolean beingPressed;

    /**
     * constroctor of the KeyPressStoppableAnimation object.
     *
     * @param keyboardSensor is the keyboardSensor sensor.
     * @param key
     * @param animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor keyboardSensor, String key, Animation animation) {
        this.keyboardSensor = keyboardSensor;
        this.key = key;
        this.animation = animation;
        this.closeScreen = false;
        this.beingPressed = true;
    }

    /**
     * this method is the frame-management code.
     *
     * @param d is the DrawSurface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        //already paused
        if (this.keyboardSensor.isPressed(this.key) && !this.beingPressed) {
            this.closeScreen = true;
        }
        //now pause
        if (!this.keyboardSensor.isPressed(this.key)) {
            this.beingPressed = false;
        }
    }

    /**
     * this method in charge of the game-specific logic and stopping conditions are handled.
     *
     * @return true when the current game frame should stop. false, when  shouldn't stop.
     */
    @Override
    public boolean shouldStop() {
        return this.closeScreen;
    }
}
