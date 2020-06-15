package levels;

import animation.AnimationRunner;
import biuoop.KeyboardSensor;
import settings.Counter;
import sprites.ScoreIndicator;

import java.util.List;

/**
 * this class manages the game flow.
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private Counter score;
    private AnimationRunner animationRunner;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar the animationRunner
     * @param ks the KeyboardSensor
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.score = new Counter(0);
    }

    /**
     * this method runs all the game levels.
     *
     * @param levels the game levels
     */
    public void runLevels(List<LevelInformation> levels) {
        System.out.println("runLevels");
        System.out.println("size:" + levels.size());
        for (LevelInformation levelInfo : levels) {
            System.out.println("runLevels in for");
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner);
            level.initialize();
            ScoreIndicator si = new ScoreIndicator(this.score); //keep track of score between levels
            level.addSprite(si);
            //keep playing game
            level.run();
            //go to next level

            System.out.println("b4 runlevel if");
            //stop game = game over
            if (levelInfo.numberOfBalls() == 0) {
                break;
            }
            System.out.println("after runlevel if");
        }
    }
}
