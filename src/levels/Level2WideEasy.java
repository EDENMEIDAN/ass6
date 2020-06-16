package levels;

import interfaces.Sprite;
import screens.BackgroundLevel2;
import settings.Velocity;
import sprites.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the second level of the game.
 */
public class Level2WideEasy implements LevelInformation {
    private Sprite background;
    private List<Block> blocks;
    private List<Velocity> initialBallVelocities;

    /**
     * this method construct level 2.
     */
    public Level2WideEasy() {
        this.background = new BackgroundLevel2();
        this.blocks = new ArrayList<>();
        int i;
        // 2 red
        for (i = 0; i < 2; ++i) {
            Block block = new Block(i * 50 + 25, 250, 50, 20, Color.RED, 1);
            this.blocks.add(block);
        }
        //2 ORANGE
        for (; i < 4; ++i) {
            Block block = new Block(i * 50 + 25, 250, 50, 20, Color.ORANGE, 1);
            this.blocks.add(block);
        }
        //2 YELLOW
        for (; i < 6; ++i) {
            Block block = new Block(i * 50 + 25, 250, 50, 20, Color.YELLOW, 1);
            this.blocks.add(block);
        }
        //3 GREEN
        for (; i < 9; ++i) {
            Block block = new Block(i * 50 + 25, 250, 50, 20, Color.GREEN, 1);
            this.blocks.add(block);
        }
        //2 BLUE
        for (; i < 11; ++i) {
            Block block = new Block(i * 50 + 25, 250, 50, 20, Color.BLUE, 1);
            this.blocks.add(block);
        }
        //2 PINK
        for (; i < 13; ++i) {
            Block block = new Block(i * 50 + 25, 250, 50, 20, Color.PINK, 1);
            this.blocks.add(block);
        }
        //2 LIGHT BLUE
        for (; i < 15; ++i) {
            Block block = new Block(i * 50 + 25, 250, 50, 20, Color.CYAN, 1);
            this.blocks.add(block);
        }
        // ball velocities
        /*this.initialBallVelocities = new ArrayList<Velocity>();
        this.initialBallVelocities.add(Velocity.fromAngleAndSpeed(-4, 4));*/
        this.initialBallVelocities = new ArrayList<>();
        // loop for arched balls
        for (int j = 1; j < 12; j += 1) {
            if (j == 6) {
                continue;
            }
            this.initialBallVelocities.add(Velocity.fromAngleAndSpeed(Math.toRadians(-16 * j), 4));
        }
    }

    /**
     * this method returns number of balls of a certain level.
     *
     * @return number of balls.
     */
    @Override
    public int numberOfBalls() {
        return this.initialBallVelocities.size();
    }

    /**
     * this method returns a list of the different balls velocities.
     *
     * @return list list of balls' velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        return this.initialBallVelocities;
    }

    /**
     * this method returns the paddle's speed.
     *
     * @return paddle's speed.
     */
    @Override
    public int paddleSpeed() {
        return 2;
    }

    /**
     * this method returns the paddle's width.
     *
     * @return paddle's width.
     */
    @Override
    public int paddleWidth() {
        return 600;
    }

    /**
     * this method returns the level's name as a string. the level name will be displayed at the top of the screen.
     *
     * @return the level's name as a string.
     */
    @Override
    public String levelName() {
        return "Wide Easy";
    }

    /**
     * this method returns a sprite with the level's background.
     *
     * @return the level's background.
     */
    @Override
    public Sprite getBackground() {
        return this.background;
    }

    /**
     * this method returns a list of level's blocks.
     *
     * @return a list of the level's blocks.
     */
    @Override
    public List<Block> blocks() {
        return this.blocks;
    }

    /**
     * this method returns the number of blocks that should be removed before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return number of blocks left on the screen.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return this.blocks.size();
    }
}
