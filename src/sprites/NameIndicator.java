package sprites;

import biuoop.DrawSurface;
import geometry.Rectangle;
import interfaces.Sprite;
import levels.GameLevel;

import java.awt.Color;

/**
 * This class represents the level name indicator object.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since 16/06/20
 */
public class NameIndicator implements Sprite {
    private String levelsName;
    private Rectangle rectangle;

    /**
     * this method constructs the LevelNameIndicator object.
     *
     * @param levelName the levels name.
     */
    public NameIndicator(String levelName) {
        this.levelsName = levelName;
        this.rectangle = new Rectangle(600, 0, 200, 15);
    }

    /**
     * this method draws a LevelNameIndicator on a given surface.
     *
     * @param d the draw surface on the screen to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.LIGHT_GRAY);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        d.setColor(Color.BLACK);
        d.drawText((int) (this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() / 2 - 80),
                (int) (this.rectangle.getUpperLeft().getY() + this.rectangle.getHeight() / 2 + 5),
                "Level Name: " + this.levelsName, 13);
    }

    /**
     * this method notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
    }

    /**
     * this method adds the LevelNameIndicator to the game.
     *
     * @param game the game.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}