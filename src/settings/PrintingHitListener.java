package settings;

import interfaces.HitListener;
import sprites.Ball;
import sprites.Block;

/**
 * This class represents an object that prints information about the blocks that were already hit.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 03/06/2020
 */
public class PrintingHitListener implements HitListener {
    /**
     * this method prints information about blocks that were already hit.
     *
     * @param beingHit the block that was hit.
     * @param hitter the hitting ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A sprites.Block was hit.");
    }
}