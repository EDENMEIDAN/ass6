package animation;

import biuoop.DrawSurface;

/**
 * A interface that represents a Animation object.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 11/06/2020
 */

public interface Animation {
    /**
     * this method is the frame-management code.
     *
     * @param d is the DrawSurface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * this method in charge of the game-specific logic and stopping conditions are handled.
     *
     * @return true when the current game frame should stop. false, when  shouldn't stop.
     */
    boolean shouldStop();
}