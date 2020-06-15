package gameLevel;

import animation.AnimationRunner;
import biuoop.KeyboardSensor;
import settings.Const;
import settings.Counter;
import sprites.ScoreIndicator;

import java.util.List;

/**
 * The type Game flow.
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private Counter score;
    private AnimationRunner animationRunner;
    private int horizontalBound;
    private int verticalBound;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar the animationRunner
     * @param ks the KeyboardSensor
     * @param horizontalBound the screens width
     * @param verticalBound the screens height
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, int horizontalBound, int verticalBound) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.score = new Counter(0);
        this.horizontalBound = Const.getScreenWidth();
        this.verticalBound = Const.getPaddleHeight();
    }

    /**
     * this method runs all the game levels.
     *
     * @param levels the game levels
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner);
            level.initialize();
            ScoreIndicator si = new ScoreIndicator(this.score);
            level.addSprite(si);
            while ((levelInfo.numberOfBlocksToRemove() != 0) && (levelInfo.numberOfBalls() != 0)) {
                level.run();
            }
            if (levelInfo.numberOfBalls() == 0 || levelInfo.numberOfBlocksToRemove() == 0) {
                break;
            }
        }
    }
}
