package levels;

import interfaces.Sprite;
import screens.BackgroundLevel3;
import settings.Velocity;
import sprites.Block;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the third level of the game.
 */
public class Level3Green3 implements LevelInformation {
    private Sprite background;
    private List<Block> blocks;
    private List<Velocity> initialBallVelocities;

    /**
     * this method constructs level 3.
     */
    public Level3Green3() {
        this.background = new BackgroundLevel3();
        this.blocks = new ArrayList<>();
        //10 gray - double hit!
        for (int i = 0; i < 10; ++i) {
            Block blockArrayList = new Block(725 - i * 50, 140, 50, 20, Color.GRAY, 2);
            this.blocks.add(blockArrayList);
        }
        //9 red
        for (int i = 0; i < 9; ++i) {
            Block blockArrayList = new Block(725 - i * 50, 160, 50, 20, Color.RED, 1);
            this.blocks.add(blockArrayList);
        }
        //8 yellow
        for (int i = 0; i < 8; ++i) {
            Block blockArrayList = new Block(725 - i * 50, 180, 50, 20, Color.YELLOW, 1);
            this.blocks.add(blockArrayList);
        }
        //7 blue
        for (int i = 0; i < 7; ++i) {
            Block blockArrayList = new Block(725 - i * 50, 200, 50, 20, Color.BLUE, 1);
            this.blocks.add(blockArrayList);
        }
        //6 white
        for (int i = 0; i < 6; ++i) {
            Block blockArrayList = new Block(725 - i * 50, 220, 50, 20, Color.WHITE, 1);
            this.blocks.add(blockArrayList);
        }
        this.initialBallVelocities = new ArrayList<>();
        this.initialBallVelocities.add(new Velocity(2, -2));
        this.initialBallVelocities.add(new Velocity(-2, -2));
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
        return "Green 3";
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