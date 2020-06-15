import animation.AnimationRunner;
import biuoop.GUI;
import levels.GameFlow;
import levels.Level1DirectHit;
import levels.Level2WideEasy;
import levels.Level3Green3;
import levels.Level4FinalFour;
import levels.LevelInformation;
import settings.Const;

import java.util.ArrayList;
import java.util.List;

/**
 * this class is the program's main class.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 14/06/2020
 */
public class Ass6Game {
    /**
     * this method is the Main method that initializes and runs the whole game!
     *
     * @param args this array stores the user's input. at the moment is empty.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", Const.getScreenWidth(), Const.getScreenHight());
        AnimationRunner runner = new AnimationRunner(gui);
        //LevelInformation level = new Level1DirectHit();
        List<LevelInformation> levels = new ArrayList<LevelInformation>();

        LevelInformation level1 = new Level1DirectHit();
        levels.add(level1);
        LevelInformation level2 = new Level2WideEasy();
        levels.add(level2);
        LevelInformation level3 = new Level3Green3();
        levels.add(level3);
        LevelInformation level4 = new Level4FinalFour();
        levels.add(level4);

        GameFlow gameFlow = new GameFlow(runner, gui.getKeyboardSensor());
        gameFlow.runLevels(levels);
        //GameLevel game = new GameLevel(level);

//        for loop to create levels?
//        GameFlow game = new GameFlow(ar, gui.getKeyboardSensor(), 7, 800, 600);
//        game.runLevels(levels);
//        gui.close();
        //game.initialize();
        //game.run();
    }
}