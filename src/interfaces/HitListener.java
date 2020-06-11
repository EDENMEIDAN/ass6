package interfaces;

import sprites.Ball;
import sprites.Block;

/**
 * this interface represents the hit listener.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 03/06/2020
 */
public interface HitListener {
    /**
     * this method is called whenever the beingHit object is being hit.
     * The hitter parameter is the sprites.Ball that's doing the hitting.
     *
     * @param beingHit the block that is being hit.
     * @param hitter the hitting ball.
     */
    void hitEvent(Block beingHit, Ball hitter);
}