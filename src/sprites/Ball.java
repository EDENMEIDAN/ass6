package sprites;

import biuoop.DrawSurface;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import interfaces.Sprite;
import levels.GameLevel;
import settings.CollisionInfo;
import settings.GameEnvironment;
import settings.Velocity;

import java.awt.Color;

/**
 * A class that represents a sprites.Ball.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 06/05/2020
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private Color color;
    private Velocity v;
    private GameEnvironment gameEnvironment;

    /**
     * constructs a ball from a center point, radius length, color and velocity.
     *
     * @param center the point in the center of the ball.
     * @param r the radius of the ball.
     * @param color the color of the ball.
     * @param v the velocity of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color, Velocity v) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.v = v;
        this.gameEnvironment = new GameEnvironment();
    }

    /**
     * constructs a ball from a center point, radius length, color, velocity and gameEnvironment.
     *
     * @param center the point in the center of the ball.
     * @param r the radius of the ball.
     * @param color the color of the ball.
     * @param v the velocity of the ball.
     * @param gameEnvironment he game environment of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color, Velocity v, GameEnvironment gameEnvironment) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.v = v;
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * construct ball from center x axis of the center point, y axis of the center point, radius, color and velocity.
     *
     * @param x axis of the center point of the ball.
     * @param y axis of the center point of the ball.
     * @param r the radius of the ball.
     * @param color the color of the ball.
     * @param v the velocity of the ball.
     */
    public Ball(int x, int y, int r, java.awt.Color color, Velocity v) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.v = v;
        this.gameEnvironment = new GameEnvironment();
    }

    /**
     * this method returns the x value of the center point of the ball.
     *
     * @return the x value of the center point of the ball.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * this method re-sets the x value of the center point of the ball.
     *
     * @param x the x value of the center point of the ball.
     */
    public void setX(int x) {
        this.center.setX(x);
    }

    /**
     * this method returns the y value of the center point of the ball.
     *
     * @return the y value of the center point of the ball.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * this method re-sets the y value of the center point of the ball.
     *
     * @param y the y value of the center point of the ball.
     */
    public void setY(int y) {
        this.center.setY(y);
    }

    /**
     * this method returns the radius of the the ball.
     *
     * @return the radius of the the ball.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * this method re-sets the radius size of the ball.
     *
     * @param radius the radius size of the ball.
     */
    public void setSize(int radius) {
        this.r = radius;
    }

    /**
     * this method re-sets the ball's center point to a new point.
     *
     * @param x the x axis of the ball's center point.
     * @param y the y axis of the ball's center point.
     */
    public void setCenter(double x, double y) {
        this.center.setX(x);
        this.center.setY(y);
    }

    /**
     * this method returns the ball's color.
     *
     * @return the ball's color.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * this method draws the ball in the right place, size and color on the given drawSurface.
     *
     * @param surface the surface of the screen where we print out the ball.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.drawCircle(this.getX(), this.getY(), this.getSize());

        surface.setColor(this.getColor());
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
    }

    /**
     * this method returns the ball's velocity.
     *
     * @return the ball's velocity.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     * this method re-sets the ball's velocity.
     *
     * @param dx is the ball's velocity in the x axis.
     * @param dy is the ball's velocity in the y axis.
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     * this method sets the ball's velocity.
     *
     * @param velocity gameSettings.Velocity object to apply on the ball.
     */
    public void setVelocity(Velocity velocity) {
        this.v = velocity;
    }

    /**
     * this method receives the surface range where the ball can bounce in without getting out of the surface.
     *
     * @param minX the minimal x axis of the frame.
     * @param minY the minimal y axis of the frame.
     * @param lengthX the horizontal total length of the frame.
     * @param lengthY the vertical total length of the frame.
     */
    public void moveOneStep(int minX, int minY, int lengthX, int lengthY) {
        //if statements
        if (this.center.getX() - this.r + getVelocity().getDx() <= minX) { //change dx when hits left of frame
            if (getVelocity().getDx() > 0) {
                this.center = this.getVelocity().applyToPoint(this.center);
            }
            double newDx = (getVelocity().getDx()) * (-1); //re-direct
            setVelocity(newDx, getVelocity().getDy());
            this.center = this.getVelocity().applyToPoint(this.center);
        }
        if (this.center.getX() + this.r + getVelocity().getDx() >= lengthX + minX) { //change dx when hits the right
            if (getVelocity().getDx() < 0) {
                this.center = this.getVelocity().applyToPoint(this.center);
            }
            double newDx = (getVelocity().getDx()) * (-1); //re-direct
            setVelocity(newDx, getVelocity().getDy());
            this.center = this.getVelocity().applyToPoint(this.center);
        }
        if (this.center.getY() + this.r + getVelocity().getDy() >= lengthY + minY) { //change dy when hits bottom
            if (getVelocity().getDx() < 0) {
                this.center = this.getVelocity().applyToPoint(this.center);
            }
            double newDy = (getVelocity().getDy()) * (-1); //re-direct
            setVelocity(getVelocity().getDx(), newDy);
            this.center = this.getVelocity().applyToPoint(this.center);
        }
        if (this.center.getY() - this.r + getVelocity().getDy() <= minY) { //change dy when hits top of frame
            if (getVelocity().getDy() > 0) {
                this.center = this.getVelocity().applyToPoint(this.center);
            }
            double newDy = (getVelocity().getDy()) * (-1); //re-direct
            setVelocity(getVelocity().getDx(), newDy);
            this.center = this.getVelocity().applyToPoint(this.center);
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * this method re-sets the center point according to its velocity right near the collisionPoint.
     *
     * @param colInfo contains the information about the collision.
     */
    public void moveOneStepAlmostCollision(CollisionInfo colInfo) {
        Point collisionPoint = colInfo.collisionPoint();
        Rectangle collisionRectangle = colInfo.collisionObject().getCollisionRectangle();
        // col is on the top line of the rectangle
        if (collisionRectangle.getTop().isContainingPoint(collisionPoint)) {
            this.center = new Point(collisionPoint.getX(), collisionPoint.getY() - 5);
        }
        // col is on the bottom line of the rectangle
        if (collisionRectangle.getBottom().isContainingPoint(collisionPoint)) {
            this.center = new Point(collisionPoint.getX(), collisionPoint.getY() + 5);
        }
        // col is on the right line of the rectangle
        if (collisionRectangle.getRight().isContainingPoint(collisionPoint)) {
            this.center = new Point(collisionPoint.getX() + 5, collisionPoint.getY());
        }
        // col is on the left line of the rectangle
        if (collisionRectangle.getLeft().isContainingPoint(collisionPoint)) {
            this.center = new Point(collisionPoint.getX() - 5, collisionPoint.getY());
        }
    }

    /**
     * this method checks if collosion will happen.
     * if does - moves object according to velocity until near the collisionPoint and there gives it a new vel.
     * if doesn't - moves object according to velocity until hits the screen frame and there gives it a new vel.
     */

    public void moveOneStep() {
        Line trajectory = new Line(this.center, this.getVelocity().applyToPoint(this.center));
        CollisionInfo colInfo = this.gameEnvironment.getClosestCollision(trajectory);
        if (colInfo == null) { // no collision
            this.center = this.getVelocity().applyToPoint(this.center);
            return;
        } else { // we have collision
            moveOneStepAlmostCollision(colInfo); // in new wanted der
            // new vel --
            this.setVelocity(colInfo.collisionObject().hit(this, colInfo.collisionPoint(), this.getVelocity()));
        }
    }

    /**
     * this method returns the game environment of the ball.
     *
     * @return the game environment of the ball.
     */
    public GameEnvironment getEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * this method notifies the ball that a time unit has passed.
     */
    public void timePassed() {

        this.moveOneStep();
    }

    /**
     * this method is a setter of the correct gameSettings.GameEnvironment.
     *
     * @param myEnvironment is the game gameSettings.GameEnvironment
     */
    public void setEnvironment(GameEnvironment myEnvironment) {
        this.gameEnvironment = myEnvironment;
    }

    /**
     * this method adds the ball to the game sprite's list.
     *
     * @param game the correct game we are playing.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    /**
     * this method removes the ball from the game's sprite list.
     *
     * @param game the game that is being played.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}