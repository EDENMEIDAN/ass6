package levels;

import interfaces.Sprite;
import settings.Velocity;
import sprites.Block;

import java.util.List;

/**
 * this interface represents objects that holds the information of the game level.
 */
public interface LevelInformation {
    /**
     * this method returns number of balls of a certain level.
     *
     * @return number of balls.
     */
    int numberOfBalls();

    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()

    /**
     * this method returns a list of the different balls velocities.
     *
     * @return list list of balls' velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * this method returns the paddle's speed.
     *
     * @return paddle's speed.
     */
    int paddleSpeed();

    /**
     * this method returns the paddle's width.
     *
     * @return paddle's width.
     */
    int paddleWidth();


    /**
     * this method returns the level's name as a string. the level name will be displayed at the top of the screen.
     *
     * @return the level's name as a string.
     */
    String levelName();

    /**
     * this method returns a sprite with the level's background.
     *
     * @return the level's background.
     */
    Sprite getBackground();

    /**
     * this method returns a list of level's blocks.
     *
     * @return a list of the level's blocks.
     */
    List<Block> blocks();
    // The Blocks that make up this level, each block contains
    // its size, color and location.

    /**
     * this method returns the number of blocks that should be removed before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return number of blocks left on the screen.
     */
    int numberOfBlocksToRemove();
}
