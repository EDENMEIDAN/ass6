package settings;

import interfaces.HitListener;
import levels.GameLevel;
import sprites.Ball;
import sprites.Block;

/**
 * this class represents a ball remover.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 03/06/2020
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * construct a ball remover from a game and and counter of balls.
     *
     * @param game a game to remove balls from.
     * @param remainingBalls the number of balls to remove.
     */
    public BallRemover(GameLevel game, Counter remainingBalls) {
        this.game = game;
        this.remainingBalls = remainingBalls;
    }

    /**
     * this method is called when a ball is hitting the death region.
     * the method removes the ball from the game and updates the number of
     * balls that left in the game.
     *
     * @param beingHit the block that is being hit (the death region).
     * @param hitter the hitting ball.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}