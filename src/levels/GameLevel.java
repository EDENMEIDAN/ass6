package levels;

import animation.Animation;
import animation.AnimationRunner;
import animation.CountdownAnimation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometry.Point;
import geometry.Rectangle;
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.Sprite;
import screens.PauseScreen;
import settings.BallRemover;
import settings.BlockRemover;
import settings.Const;
import settings.Counter;
import settings.GameEnvironment;
import settings.ScoreTrackingListener;
import settings.SpriteCollection;
import settings.Velocity;
import sprites.Ball;
import sprites.Block;
import sprites.Paddle;
import sprites.ScoreIndicator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a GameLevel.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since 03/02/2020
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter score;
    private Counter blocksCounter;
    private Counter ballsCounter;
    private AnimationRunner animationRunner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;
    private Paddle paddle;

    /**
     * this method constructs new level object.
     *
     * @param level object for the current level.
     * @param keyboard the KeyboardSensor.
     * @param animationRunner he animationRunner.
     * @param score the game score.
     */
    public GameLevel(LevelInformation level, KeyboardSensor keyboard, AnimationRunner animationRunner, Counter score) {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.sprites.addSprite(level.getBackground()); //added
        this.blocksCounter = new Counter(0);
        this.ballsCounter = new Counter(0);
        this.animationRunner = animationRunner;
        this.keyboard = keyboard;
        this.running = true;
        this.levelInformation = level;
        this.score = score;
    }

    /**
     * this method adds collidable object into gameEnvironment.
     *
     * @param c a collidable object.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * this method adds a sprite object into the game.
     *
     * @param s is a given sprite object.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * this method initializes a new game and creates blocks, balls and a paddle and add them to the game.
     * and populates the gameSettings.SpriteCollection and the gameSettings.GameEnvironment
     */
    public void initialize() {
        // System.out.println("initialize");
        createScore();
        createBlocks();
    }

    /**
     * this method created the score ScoreIndicator and adds it to the game.
     */
    private void createScore() {
        //System.out.println("createScore");
        // Score Indicator
        ScoreIndicator si = new ScoreIndicator(this.score);
        si.addToGame(this);
    }

    /**
     * this method creates the 4 boarder blocks and the game blocks and adds them with the right logic to the game.
     */
    private void createBlocks() {
        //System.out.println("createBlocks");
        HitListener stl = new ScoreTrackingListener(this.score);
        //our block/ball removers
        BlockRemover blockRemover = new BlockRemover(this, this.blocksCounter);
        BallRemover ballRemover = new BallRemover(this, this.ballsCounter);

        //creates 4 block around draw surface perimeter
        List<Block> blockList = new ArrayList<>();
        //upBound
        blockList.add(new Block(new Point(0, 20), Const.getScreenWidth(), 20, Color.GRAY));
        //killerBound - bottom bound
        blockList.add(new Block(new Point(0, Const.getScreenHight()), Const.getScreenWidth(), 1, Color.pink));
        //leftBound
        blockList.add(new Block(new Point(0, 20), 20, Const.getScreenHight(), Color.GRAY));
        //rightBound
        blockList.add(new Block(new Point(Const.getScreenWidth() - 20, 20), 20, Const.getScreenHight(), Color.GRAY));

        // add blocks to game
        for (Block b : blockList) {
            b.addToGame(this);
        }
        blockList.get(1).addHitListener(ballRemover); //killerBound - bottom bound

        // creates the game blocks
        for (Block block : levelInformation.blocks()) {
            block.addToGame(this);
            block.addHitListener(stl);
            block.addHitListener(blockRemover);
            this.blocksCounter.increase(1); //reset
        }
        blockRemover.setRemainingBlockCounter(this.blocksCounter);
    }

    /**
     * this method creates the paddle and the balls to the game.
     */
    public void createBallsOnTopOfPaddle() {
        //System.out.println("createBallsOnTopOfPaddle");
        // add paddle to the games
        /*Point upperLeft = new Point(375, 575);
        Rectangle rect = new Rectangle(upperLeft, levelInformation.paddleWidth(), Const.getPaddleHeight());
        Paddle ourPaddle = new Paddle(this.animationRunner.getGui(), rect);*/

        this.paddle = new Paddle(new Rectangle(new Point(
                Const.getScreenWidth() / 2 - levelInformation.paddleWidth() / 2, Const.getScreenHight() - 35),
                levelInformation.paddleWidth(), 15), this.keyboard);
        this.levelInformation.paddleSpeed();


        this.paddle.addToGame(this);
        //add balls to the game
        int numberOfBalls = levelInformation.numberOfBalls();
        this.ballsCounter.setValue(numberOfBalls); //reset ball counter
        for (Velocity v : levelInformation.initialBallVelocities()) {
            Ball newBall = new Ball(new Point(Const.getScreenWidth() / 2,
                    Const.getScreenHight() - Const.getPaddleHeight() - 20), 5, Color.WHITE, v, this.environment);
            this.addSprite(newBall);
        }
    }

    /**
     * his method set the game background according to a given color.
     */
    public void setBackground() {
        addSprite(levelInformation.getBackground());
    }

    /**
     * this method initializes a new game: Blocks, sprites.Paddle and sprites.Ball.
     *
     * @param c a collidable object that is going to be removed from the the environment collidableList.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * this method removes a interfaces.Sprite object from the sprites.
     *
     * @param s the interfaces.Sprite object being removed.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * this method runs the game animation in a loop.
     */
    public void run() {
        //System.out.println("gamerun");
        this.createBallsOnTopOfPaddle(); // or a similar method
        // countdown before turn starts
        this.animationRunner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of the game.
        this.animationRunner.run(this);
    }

    /**
     * this method draws the current state of the animation object to the screen.
     *
     * @param d is the DrawSurface.
     */
    public void doOneFrame(DrawSurface d) {
        //System.out.println("doOneFrame");
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        if (this.keyboard.isPressed("p")) {
            this.animationRunner.run(new PauseScreen(this.keyboard));
        }
        if (blocksCounter.getValue() == 0 || this.ballsCounter.getValue() == 0) { //end level
            if (blocksCounter.getValue() == 0) {
                this.score.increase(100);
            }
            this.running = false;
        }
    }

    /**
     * this method in charge of the game-specific logic and stopping conditions are handled.
     *
     * @return true when the current game frame should stop. false, when shouldn't stop.
     */
    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * this method checks if game should be ended.
     *
     * @return true if should end, otherwise-- false.
     */
    public boolean isEndGame() {
        return (this.ballsCounter.getValue() == 0);
    }
}