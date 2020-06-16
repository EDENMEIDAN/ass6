package levels;

import animation.AnimationRunner;
import biuoop.KeyboardSensor;
import screens.EndScreen;
import screens.KeyPressStoppableAnimation;
import settings.Counter;
import sprites.NameIndicator;
import sprites.ScoreIndicator;

import java.util.List;

/**
 * this class manages the game flow.
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
        this.youWin = false;
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
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, this.score);
            level.initialize();
            ScoreIndicator scoreIndicator = new ScoreIndicator(this.score); //keep track of score between levels
            level.addSprite(scoreIndicator);
            System.out.println("runLevels after score");
            NameIndicator nameIndicator = new NameIndicator(levelInfo.levelName());
            level.addSprite(nameIndicator);
            System.out.println("b4 runLevels level.run()");
            level.run();  //keep playing game

            //go to next level
            System.out.println("after runlevel level.run()");
            //stop game = game over
            if (level.isEndGame()) {
                System.out.println("game lost");
                break; //player lost
            } else {
                this.youWin = true;
            }
        }
        System.out.println("gameflow done");
        //animationRunner.getGui().close();
        this.animationRunner.run(new KeyPressStoppableAnimation(
                this.keyboardSensor, "space", new EndScreen(this.score, this.youWin)));
    }
}