package sprites;

import biuoop.DrawSurface;
import geometry.Rectangle;
import interfaces.Sprite;
import levels.GameLevel;
import settings.Counter;

import java.awt.Color;

/**
 * This class represents a score indicator object.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    private Rectangle rect;

    /**
     * Construct a score indicator from a score counter object.
     *
     * @param score the given score counter.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
        this.rect = new Rectangle(200, 0, 400, 15);
    }

    /**
     * this method draws the score indicator on given DrawSurface.
     *
     * @param surface the DrawSurface to draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.LIGHT_GRAY);
        surface.fillRectangle(0, 0, 800, 20);
        surface.setColor(Color.BLACK);
        surface.drawText((int) (this.rect.getUpperLeft().getX() + this.rect.getWidth() / 2 - 20),
                (int) (this.rect.getUpperLeft().getY() + this.rect.getHeight() / 2 + 5),
                "Score: " + this.score.getValue(), 13);
    }

    /**
     * this method notifies the score indicator that a time unit has passed.
     */
    public void timePassed() {
    }

    /**
     * this method adds the score indicator to a game.
     *
     * @param game the game.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}