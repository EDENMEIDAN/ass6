package settings;

import biuoop.DrawSurface;
import interfaces.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * A gameSettings.SpriteCollection class that creates a collection of sprite objects.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 06/05/2020
 */
public class SpriteCollection {
    private List<Sprite> spriteList = new ArrayList<Sprite>();

    /**
     * this method is a constructor of gameSettings.SpriteCollection.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<Sprite>();
    }

    /**
     * this method adds a given sprite object to the collection.
     *
     * @param s the sprite object being added to the collection.
     */
    public void addSprite(Sprite s) {
        this.spriteList.add(s);
    }

    /**
     * this method removes a sprite object from collection.
     * @param s the given sprite object.
     */
    public void removeSprite(Sprite s) {
        this.spriteList.remove(s);
    }

    /**
     * this method notifies all sprite objects that the time has passed by calling timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        for (int i = 0; i < spriteList.size(); ++i) {
            Sprite s = spriteList.get(i);
            if (s != null) {
                s.timePassed();
            }
        }
    }

    /**
     * this method draws the sprite objects on to the draw surface.
     *
     * @param d the DrawSurface to draw on.
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < spriteList.size(); ++i) {
            this.spriteList.get(i).drawOn(d);
        }
    }

    /**
     * this method is a setter of the SpriteList of all sprite objects.
     *
     * @param spritesList a list of all sprite objects.
     */
    public void setSpriteList(List<Sprite> spritesList) {
        this.spriteList = spritesList;
    }
}