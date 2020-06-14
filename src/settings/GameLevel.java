package settings;

import animation.Animation;
import animation.AnimationRunner;
import animation.CountdownAnimation;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import gameScreens.PauseScreen;
import geometry.Point;
import geometry.Rectangle;
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.Sprite;
import sprites.Ball;
import sprites.Block;
import sprites.Paddle;
import sprites.ScoreIndicator;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A class that represents a gameSettings.Game.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 03/02/2020
 */
public class GameLevel implements Animation {
    private static int screenHeight = 600;
    private static int screenWidth = 800;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter score;
    private Counter blocksCounter;
    private Counter ballsCounter;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;


    /**
     * this method constructs new game object.
     */
    public GameLevel() {
        this.environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.score = new Counter(0);
        this.blocksCounter = new Counter();
        this.ballsCounter = new Counter(3);
        //this.runner = new AnimationRunner();
        this.keyboard = runner.getGui().getKeyboardSensor();
        this.running = true;
    }

    /**
     * this method constructs a gameLevel object.
     *
     * //@param level the levelInfornation object for the current level.
     *
     * @param keyboard a keyboard sensor connected to a gui object.
     * @param animationRunner an animation runner connected to a gui object.
     * @param score a score counter holding the current score.
     * //@param lives a lives counter holding the current lives.
     * //@param horizontalBound the available width.
     * //@param verticalBound the available height.
     */

    //LevelInformation level,
//    public void GameLevel(KeyboardSensor keyboard, AnimationRunner animationRunner, Counter score) {
//        this.environment = new GameEnvironment();
//        this.sprites = new SpriteCollection();
//        //this.sprites.addSprite(level.getBackground());
//        this.runner = animationRunner;
//        //this.remainingBlocks = new Counter(level.numberOfBlocksToRemove());
//        this.ballsCounter = new Counter(0);
//        this.keyboard = keyboard;
//        this.score = score;
//        this.running = true;
//    }

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
        System.out.println("initialize");
        createScore();
        createBlocks();
    }

    /**
     * this method created the score ScoreIndicator and adds it to the game.
     */
    private void createScore() {
        System.out.println("createScore");
        // Score Indicator
        ScoreIndicator si = new ScoreIndicator(this.score);
        si.addToGame(this);
    }

    /**
     * this method creates the 4 boarder blocks and the game blocks and adds them with the right logic to the game.
     */
    private void createBlocks() {
        System.out.println("createBlocks");
        HitListener stl = new ScoreTrackingListener(this.score);
        //our block/ball removers
        BlockRemover blockRemover = new BlockRemover(this, this.blocksCounter);
        BallRemover ballRemover = new BallRemover(this, this.ballsCounter);

        //creates 4 block around draw surface perimeter
        List<Block> blockList = new ArrayList<>();
        //upBound
        blockList.add(new Block(new Point(0, 20), screenWidth, 20, Color.GRAY));
        //killerBound - bottom bound
        blockList.add(new Block(new Point(0, screenHeight), screenWidth, 1, Color.pink));
        //leftBound
        blockList.add(new Block(new Point(0, 20), 20, screenHeight, Color.GRAY));
        //rightBound
        blockList.add(new Block(new Point(screenWidth - 20, 20), 20, screenHeight, Color.GRAY));

        // add blocks to game
        for (Block b : blockList) {
            b.addToGame(this);
        }
        blockList.get(1).addHitListener(ballRemover); //killerBound - bottom bound

        // creates the blocks
        Random rand = new Random();
        //gameSettings.PrintingHitListener hl = new gameSettings.PrintingHitListener();
        for (int i = 0; i < 6; i++) {
            //gameSettings.PrintingHitListener hl = new gameSettings.PrintingHitListener(); //test
            Color c = new Color(rand.nextInt(250), rand.nextInt(250), rand.nextInt(250));
            for (int j = 0; j < 12 - i; j++) {
                int blockWidth = 55;
                int blockHeight = 30;
                Point upperLeftPoint = new Point(screenWidth - 20 - (j + 1) * blockWidth, 120 + blockHeight * i);
                Block newBlock = new Block(upperLeftPoint, blockWidth, blockHeight, Color.black);
                newBlock.setColor(c);
                newBlock.addToGame(this);
                newBlock.addHitListener(stl);
                newBlock.addHitListener(blockRemover);
                this.blocksCounter.increase(1);
            }
        }
        blockRemover.setRemainingBlockCounter(this.blocksCounter);
    }

    /**
     * this method creates the paddle and the balls to the game.
     */
    public void createBallsOnTopOfPaddle() {
        System.out.println("createBallsOnTopOfPaddle");
        // add paddle to the games
        Point upperLeft = new Point(400, 575);
        Rectangle rect = new Rectangle(upperLeft, 150, 20);
        Paddle ourPaddle = new Paddle(this.runner.getGui(), rect);
        ourPaddle.addToGame(this);

        int ballIndex = 0;
        int numberOfBalls = 3;
        for (ballIndex = 0; ballIndex < numberOfBalls; ++ballIndex) {
            Ball newBall = new Ball(new Point(screenWidth / 2 + 50, screenHeight / 2 + 100), 5, Color.WHITE,
                    Velocity.fromAngleAndSpeed(45 * ballIndex + 10, 5));
            newBall.setEnvironment(this.environment);
            this.addSprite(newBall);
        }
    }

    /**
     * this method set the game background according to a given color.
     *
     * @param d the DrawSurface of this game.
     * @param color the given colors.
     */
    public void setBackground(DrawSurface d, Color color) {
        d.setColor(color);
        d.fillRectangle(0, 0, this.runner.getGui().getDrawSurface().getWidth(),
                this.runner.getGui().getDrawSurface().getHeight());
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
        System.out.println("gamerun");
        this.createBallsOnTopOfPaddle(); // or a similar method
        this.runner.run(new CountdownAnimation(2, 3, this.sprites)); // countdown before turn starts.

        this.running = true;
        // use our runner to run the current animation -- which is one turn of the game.
        this.runner.run(this);
    }

    /**
     * this method draws the current state of the animation object to the screen.
     *
     * @param d is the DrawSurface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        System.out.println("doOneFrame");
        //d = this.runner.getGui().getDrawSurface();
        this.setBackground(d, Color.GREEN);
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
      /*  int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        Sleeper sleeper = new Sleeper();
        while (!this.shouldStop()) { //// shouldStop() is in charge of stopping condition.
            long startTime = System.currentTimeMillis(); // currentTimeMillis
            d = this.gui.getDrawSurface();
            this.setBackground(d, Color.GREEN);
            this.sprites.drawAllOn(d);

            this.doOneFrame(d); // doOneFrame(DrawSurface) is in charge of the logic.
            gui.show(d);
            this.sprites.notifyAllTimePassed();

            // timing
            long usedTime = (System.currentTimeMillis() - startTime);
            long milliSecondLeftToSleep = (millisecondsPerFrame - usedTime);
            if (milliSecondLeftToSleep > 0) { // there is more time left
            sleeper.sleepFor(milliSecondLeftToSleep);
            }
            //System.out.println("blocksCounter" + blocksCounter.getValue());
            //System.out.println("ballsCounter" + ballsCounter.getValue());*/
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }
        if (blocksCounter.getValue() == 0 || this.ballsCounter.getValue() == 0) { //end level
            //System.out.println("blocksCounter IF " + blocksCounter.getValue());
            //System.out.println("ballsCounter IF " + ballsCounter.getValue());
            if (blocksCounter.getValue() == 0) {
                this.score.increase(100);
            }
            //System.out.println(score.getValue());
            this.runner.getGui().close();
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
}