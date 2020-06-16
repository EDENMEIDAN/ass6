package levels;

import animation.AnimationRunner;
import biuoop.KeyboardSensor;
import screens.EndScreenLose;
import screens.EndScreenWin;
import screens.KeyPressStoppableAnimation;
import settings.Counter;
import sprites.NameIndicator;
import sprites.ScoreIndicator;

import java.util.List;

/**
 * this class manages the game flow.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since 16/06/20
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private Counter score;
    private AnimationRunner animationRunner;
    private boolean youWin;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar the animationRunner.
     * @param ks the KeyboardSensor.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.score = new Counter(0);
        this.youWin = true;
    }

    /**
     * this method runs all the game levels.
     *
     * @param levels the game levels
     */
    public void runLevels(List<LevelInformation> levels) {
        /*System.out.println("runLevels");
        System.out.println("size:" + levels.size());*/
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, this.score);
            level.initialize();
            ScoreIndicator scoreIndicator = new ScoreIndicator(this.score); //keep track of score between levels
            level.addSprite(scoreIndicator);
            NameIndicator nameIndicator = new NameIndicator(levelInfo.levelName());
            level.addSprite(nameIndicator);
            level.run();  //keep playing game

            //stop game = game over
            if (level.isEndGame()) {
                this.youWin = false;
                this.animationRunner.run(new KeyPressStoppableAnimation(
                        this.keyboardSensor, keyboardSensor.SPACE_KEY, new EndScreenLose(this.score)));
                break;
            }
        }
        if (youWin) {
            this.animationRunner.run(new KeyPressStoppableAnimation(
                    this.keyboardSensor, keyboardSensor.SPACE_KEY, new EndScreenWin(this.score, this.youWin)));
        }
        //animationRunner.getGui().close();
    }
}