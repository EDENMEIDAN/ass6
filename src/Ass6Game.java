import biuoop.GUI;
import gameLevel.GameLevel;
import gameLevel.Level1DirectHit;
import gameLevel.LevelInformation;

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
        GUI gui = new GUI("Arkanoid", 800, 600);


        LevelInformation level = new Level1DirectHit();
        GameLevel game = new GameLevel(level);

//        AnimationRunner ar = new AnimationRunner(gui);
//        List<LevelInformation> levels = new ArrayList<LevelInformation>();
//          for loop to create levels?
//        GameFlow game = new GameFlow(ar, gui.getKeyboardSensor(), 7, 800, 600);
//        game.runLevels(levels);
//        gui.close();

        game.initialize();
        game.run();
    }
}