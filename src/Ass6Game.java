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
        System.out.println(111);
        GUI gui = new GUI("Arkanoid", Const.getScreenWidth(), Const.getScreenHight());
        System.out.println(222);
        AnimationRunner runner = new AnimationRunner(gui, 60 / 6);
        System.out.println(333);

        //LevelInformation level = new Level1DirectHit();

        List<LevelInformation> levels = new ArrayList<LevelInformation>();
        System.out.println(444);
        LevelInformation level1 = new Level1DirectHit();
        levels.add(level1);
        System.out.println(555);
        LevelInformation level2 = new Level2WideEasy();
        levels.add(level2);
        System.out.println(666);
        LevelInformation level3 = new Level3Green3();
        levels.add(level3);
        System.out.println(777);
        LevelInformation level4 = new Level4FinalFour();
        levels.add(level4);
        System.out.println(888);
        GameFlow gameFlow = new GameFlow(runner, gui.getKeyboardSensor());
        System.out.println(999);
        gameFlow.runLevels(levels);
        System.out.println(1000);

        runner.getGui().close();
    }
}