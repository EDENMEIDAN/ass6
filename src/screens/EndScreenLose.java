package screens;

import animation.Animation;
import biuoop.DrawSurface;
import settings.Counter;

import java.awt.Color;

/**
 * This class represents the end screen object that will be displayed in the end of the game when player lost.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since 16/06/20
 */
public class EndScreenLose implements Animation {
    private int score;
    private boolean youWin;

    /**
     * the endscreen constructor.
     *
     * @param score the score counter.
     */
    public EndScreenLose(Counter score) {
        this.score = score.getValue();
    }

    /**
     * this method is the frame-management code.
     *
     * @param d is the DrawSurface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.decode("#990000"));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.BLACK);
        // wiining screen

        // losing screen
        d.drawText(210, 200, "Game Over. ", 100);
        d.setColor(Color.decode("#ffcb05"));
        //d.drawText(214, 196, "You Lost", 100);

        d.setColor(Color.BLACK);
        d.drawText(250, 350, "Press space to continue", 25);
        d.setColor(Color.WHITE);
        d.drawText(50, 580, "Your score is " + this.score, 15);
    }

    /**
     * this method in charge of the game-specific logic and stopping conditions are handled.
     *
     * @return true when the current game frame should stop. false, when  shouldn't stop.
     */
    @Override
    public boolean shouldStop() {
        return false;
    }
}
