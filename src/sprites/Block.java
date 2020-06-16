package sprites;

import biuoop.DrawSurface;
import geometry.Point;
import geometry.Rectangle;
import interfaces.Collidable;
import interfaces.HitListener;
import interfaces.HitNotifier;
import interfaces.Sprite;
import levels.GameLevel;
import settings.GameEnvironment;
import settings.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents a sprites.Block.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 06/05/2020
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rect;
    private Color color;
    private int hits;
    private List<HitListener> hitListeners;

    /**
     * constructs a sprites.Block from a geometry.Rectangle and a color.
     *
     * @param rect the rectangle that that represents the block.
     * @param color the color that fills the block.
     */
    public Block(Rectangle rect, Color color) {
        this.rect = rect;
        this.color = color;
    }

    /**
     * constructs a sprites.Block from a the rectangles: upperLeft point, width height and color.
     *
     * @param upperLeft the point location where the geometry.Rectangle starts on the upper left of the screen.
     * @param width the geometry.Rectangle's length in the x axes of the screen.
     * @param height the geometry.Rectangle's length in the y axes of the screen.
     * @param color the color that fills the block.
     * @param hits the number of hits.
     */
    public Block(Point upperLeft, double width, double height, Color color, int hits) {
        this.rect = new Rectangle(upperLeft, width, height);
        this.color = color;
        this.hits = hits;
    }

    /**
     * constructs a sprites.Block from: rectangles upperLeft point, width height and color.
     *
     * @param upperLeft the point location where the geometry.Rectangle starts on the upper left of the screen.
     * @param width the geometry.Rectangle's length in the x axes of the screen.
     * @param height the geometry.Rectangle's length in the y axes of the screen.
     * @param color the color that fills the block.
     */
    public Block(Point upperLeft, double width, double height, Color color) {
        this.rect = new Rectangle(upperLeft, width, height);
        this.color = color;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * constructs a sprites.Block from: rectangles upperLeft point, width height, color and hitListeners.
     *
     * @param upperLeft the point location where the geometry.Rectangle starts on the upper left of the screen.
     * @param width the geometry.Rectangle's length in the x axes of the screen.
     * @param height the geometry.Rectangle's length in the y axes of the screen.
     * @param color the color that fills the block.
     * @param hitListeners the list of hitlisters.
     */
    public Block(Point upperLeft, double width, double height, Color color, HitListener hitListeners) {
        this.rect = new Rectangle(upperLeft, width, height);
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * construct a block from two coordinates, width, height, color and initial number of hits.
     *
     * @param x the x coordinate of the initial location of the block's upper left corner.
     * @param y the y coordinate of the initial location of the block's upper left corner.
     * @param width the block's width.
     * @param height the block's height.
     * @param color the block's color.
     * @param hits the initial number of hits.
     */
    public Block(double x, double y, double width, double height, Color color, int hits) {
        this.rect = new Rectangle(x, y, width, height);
        this.color = color;
        this.hits = hits;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * this method gets the rectangle that the collision happens with.
     *
     * @return the rectangle the collision happens with.
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * this method draws a ball on a given surface.
     *
     * @param d the draw surface on the screen to draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) Math.round(this.rect.getUpperLeft().getX()),
                (int) Math.round(this.rect.getUpperLeft().getY()),
                (int) Math.round(this.rect.getWidth()),
                (int) Math.round(this.rect.getHeight()));
        d.setColor(Color.BLACK);
        d.drawRectangle(
                (int) Math.round(this.rect.getUpperLeft().getX()),
                (int) Math.round(this.rect.getUpperLeft().getY()),
                (int) Math.round(this.rect.getWidth()),
                (int) Math.round(this.rect.getHeight()));
    }

    /**
     * This method adds blocks to a gameEnvironment.
     *
     * @param gameEnvironment is the gameEnvironment to add blocks to
     */
    public void addBlocksToGame(GameEnvironment gameEnvironment) {
        gameEnvironment.addCollidable(this); // add blocks to gameEnvironment
    }

    /**
     * this method notifies the block that a time unit has passed.
     */
    public void timePassed() {
        //for now, kept empty
    }

    /**
     * this method gets the rectangle shape of the block object.
     *
     * @return rectangle shape of the block.
     */
    public Rectangle getRect() {
        return rect;
    }

    /**
     * this method gets the block's color.
     *
     * @return the block's color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * this method re-sets the blocks's color.
     *
     * @param col the color we are re-setting the block to.
     */
    public void setColor(Color col) {
        this.color = col;
    }

    /**
     * this method adds a block to a our current game.
     *
     * @param game our current game.
     */
    public void addToGame(GameLevel game) {
        game.addCollidable(this);
        game.addSprite(this);
    }

    /**
     * this method removes a block from the game.
     *
     * @param game the game being played.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * this method adds a given hit listener object to to hit events by adding a list of hit listeners in this
     * hit notifier.
     *
     * @param hl a given hit listener object.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * this method removes a given hit listener object from hit events by removing it from the list of hit listeners
     * in this hit notifier.
     *
     * @param hl a given hit listener object.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * this method gets a ball that is hitting a block and notifies all the hit listeners of the hit.
     *
     * @param hitter the hitting ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * this method returns the current number of hits the block has.
     *
     * @return the block's current number of hits.
     */
    public int getHits() {
        return this.hits;
    }

    // Notice that we changed the hit method to include a "sprites.Ball hitter" parameter -- update the
    // collidable interface accordingly.


    /**
     * this method gets a ball, a collision point and velocity and returns the new velocity based on the hit's
     * properties.
     *
     * @param hitter the hitting ball.
     * @param collisionPoint the collision point.
     * @param currentVelocity the current velocity.
     * @return a new velocity based on the hit's properties.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = new Velocity(currentVelocity);
        this.notifyHit(hitter);
        // hits on top and right - change dx & dy
        if (this.rect.getTop().inBoundaries(collisionPoint)
                && this.rect.getRight().inBoundaries(collisionPoint)) {
            double newDx = newVelocity.getDx() * (-1);
            newVelocity.setDx(newDx);
            double newDy = newVelocity.getDy() * (-1);
            newVelocity.setDy(newDy);
            return newVelocity;
        }
        // hits on top and left - change dx & dy
        if (this.rect.getTop().inBoundaries(collisionPoint)
                && this.rect.getLeft().inBoundaries(collisionPoint)) {
            double newDx = newVelocity.getDx() * (-1);
            newVelocity.setDx(newDx);
            double newDy = newVelocity.getDy() * (-1);
            newVelocity.setDy(newDy);
            return newVelocity;
        }
        // hits on bottom and right - change dx & dy
        if (this.rect.getBottom().inBoundaries(collisionPoint)
                && this.rect.getRight().inBoundaries(collisionPoint)) {
            double newDx = newVelocity.getDx() * (-1);
            newVelocity.setDx(newDx);
            double newDy = newVelocity.getDy() * (-1);
            newVelocity.setDy(newDy);
            return newVelocity;
        }
        // hits on bottom and left - change dx & dy
        if (this.rect.getBottom().inBoundaries(collisionPoint)
                && this.rect.getLeft().inBoundaries(collisionPoint)) {
            double newDx = newVelocity.getDx() * (-1);
            newVelocity.setDx(newDx);
            double newDy = newVelocity.getDy() * (-1);
            newVelocity.setDy(newDy);
            return newVelocity;
        }
        // hits on right or left - change dx
        if (this.rect.getLeft().inBoundaries(collisionPoint)
                || this.rect.getRight().inBoundaries(collisionPoint)) {
            double newDx = newVelocity.getDx() * (-1);
            newVelocity.setDx(newDx);
        }
        // hits on top or bottom - change dy
        if (this.rect.getTop().inBoundaries(collisionPoint)
                || this.rect.getBottom().inBoundaries(collisionPoint)) {
            double newDy = newVelocity.getDy() * (-1);
            newVelocity.setDy(newDy);
        }
        return newVelocity;
    }
}