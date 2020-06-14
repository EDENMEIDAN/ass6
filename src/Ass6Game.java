import settings.Game;

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
        System.out.println(11112);
        Game game = new Game();
        System.out.println(11113);
        //AnimationRunner animationRunner = new AnimationRunner();
        game.initialize();
        System.out.println(11114);
        game.run();
        System.out.println(11115);
        //animationRunner.run(game);
    }
}