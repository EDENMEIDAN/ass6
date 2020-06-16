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
 * @since 14/06/2020
 */
public class Ass6Game {
    /**
     * this method is the Main method that initializes and runs the whole game!
     *
     * @param args this array stores the user's input. at the moment is empty.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", Const.getScreenWidth(), Const.getScreenHight());
        AnimationRunner runner = new AnimationRunner(gui, 60 / 6);
        List<LevelInformation> levelsToPlay = new ArrayList<>();
        LevelInformation level1 = new Level1DirectHit();
        LevelInformation level2 = new Level2WideEasy();
        LevelInformation level3 = new Level3Green3();
        LevelInformation level4 = new Level4FinalFour();

        for (int i = 0; i < args.length; i++) {
            String cur = args[i];
            System.out.println("arg is: " + cur);
            if (cur.equals("1")) {
                levelsToPlay.add(level1);
            } else if (cur.equals("2")) {
                levelsToPlay.add(level2);
            } else if (cur.equals("3")) {
                levelsToPlay.add(level3);
            } else if (cur.equals("4")) {
                levelsToPlay.add(level4);
            }
        }
        if (levelsToPlay.isEmpty()) {
            levelsToPlay.add(level1);
            levelsToPlay.add(level2);
            levelsToPlay.add(level3);
            levelsToPlay.add(level4);
        }
        GameFlow gameFlow = new GameFlow(runner, gui.getKeyboardSensor());
        gameFlow.runLevels(levelsToPlay);
        runner.getGui().close();
    }
}