package levels;

import interfaces.Sprite;
import screens.BackgroundLevel4;
import settings.Velocity;
import sprites.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the fourth level of the game.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since 16/06/20
 */
public class Level4FinalFour implements LevelInformation {
    private Sprite background;
    private List<Block> blocks;
    private List<Velocity> initialBallVelocities;

    /**
     * this method constructs level 4.
     */
    public Level4FinalFour() {
        this.background = new BackgroundLevel4();
        this.blocks = new ArrayList<>();
        // create the colored blocks per line
        for (int i = 0; i < 15; ++i) {
            Block block = new Block(725 - i * 50, 140, 50, 20, Color.GRAY, 2);
            this.blocks.add(block);
        }
        for (int i = 0; i < 15; ++i) {
            Block block = new Block(725 - i * 50, 160, 50, 20, Color.RED, 1);
            this.blocks.add(block);
        }
        for (int i = 0; i < 15; ++i) {
            Block block = new Block(725 - i * 50, 180, 50, 20, Color.YELLOW, 1);
            this.blocks.add(block);
        }
        for (int i = 0; i < 15; ++i) {
            Block block = new Block(725 - i * 50, 200, 50, 20, Color.GREEN, 1);
            this.blocks.add(block);
        }
        for (int i = 0; i < 15; ++i) {
            Block block = new Block(725 - i * 50, 220, 50, 20, Color.WHITE, 1);
            this.blocks.add(block);
        }
        for (int i = 0; i < 15; ++i) {
            Block block = new Block(725 - i * 50, 240, 50, 20, Color.PINK, 1);
            this.blocks.add(block);
        }
        for (int i = 0; i < 15; ++i) {
            Block block = new Block(725 - i * 50, 260, 50, 20, Color.CYAN, 1);
            this.blocks.add(block);
        }
        this.initialBallVelocities = new ArrayList<Velocity>();
        this.initialBallVelocities.add(new Velocity(2, -2));
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
        return 5;
    }

    /**
     * this method returns the paddle's width.
     *
     * @return paddle's width.
     */
    @Override
    public int paddleWidth() {
        return 80;
    }

    /**
     * this method returns the level's name as a string. the level name will be displayed at the top of the screen.
     *
     * @return the level's name as a string.
     */
    @Override
    public String levelName() {
        return "Final Four";
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
