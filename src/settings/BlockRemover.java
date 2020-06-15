package settings;

import interfaces.HitListener;
import levels.GameLevel;
import sprites.Ball;
import sprites.Block;

/**
 * this class is a gameSettings.BlockRemover and is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 03/06/2020
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor of block remover from a game and and counter of blocks.
     *
     * @param game a game to remove blocks from.
     * @param remainingBlocks number of blocks that were removed.
     */
    public BlockRemover(GameLevel game, Counter remainingBlocks) {
        this.game = game;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * this method removes the Blocks that reach 0 hit-points and updates the number of blocks that are left
     * in the game.
     * this method is called when the beingHit object is being hit.
     *
     * @param beingHit the block that is being hit.
     * @param hitter the hitting ball.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this); //hitLister
        beingHit.removeFromGame(this.game); // block
        this.remainingBlocks.decrease(1); // updates the number of blocks that are left in the game.
    }

    /**
     * this method re-sets the number of remaining Blocks.
     *
     * @param remainingBlocksNum the number of remaining Blocks.
     */
    public void setRemainingBlockCounter(Counter remainingBlocksNum) {
        this.remainingBlocks = remainingBlocksNum;
    }
}