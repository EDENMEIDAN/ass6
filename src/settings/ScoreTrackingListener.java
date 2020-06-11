package settings;

import interfaces.HitListener;
import sprites.Ball;
import sprites.Block;

/**
 * this class represents a ScoreT racking Listener object.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 03/06/2020
 */

public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * constructor of the score tracking listener from a score counter object.
     *
     * @param score the given score counter object.
     */
    public ScoreTrackingListener(Counter score) {
        this.currentScore = score;
    }

    /**
     * this method updates the score when a block is hit.
     * When the block that is being hit is removed -- score increases by 10 points, otherwise -- 5 points.
     *
     * @param beingHit the block that is being hit.
     * @param hitter the hitting ball.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}
