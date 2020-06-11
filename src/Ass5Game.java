import biuoop.GUI;
import settings.Game;

/**
 * this class is the program's main class.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 02/06/2020
 */
public class Ass5Game {
    /**
     * this method is the Main method that initializes and runs the whole game!
     *
     * @param args this array stores the user's input. at the moment is empty.
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", 800, 600);
        Game game = new Game();
        game.initialize();
        game.run();
    }
}