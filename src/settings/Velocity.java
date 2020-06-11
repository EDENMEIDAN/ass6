package settings;

import geometry.Point;

/**
 * A gameSettings.Velocity class that specifies the change in position on the x and the y axes.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 06/05/2020
 */
public class Velocity {
    private double angle;
    private double speed;
    private double dx;
    private double dy;

    /**
     * construct gameSettings.Velocity from its speed in both the x axes and y axes.
     *
     * @param dx the gameSettings.Velocity in the x axes only.
     * @param dy the gameSettings.Velocity in the y axes only.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
        this.angle = getAngle();
        this.speed = getSpeed();
    }

    /**
     * construct gameSettings.Velocity according to a different given velocity.
     *
     * @param v a given velocity.
     */
    public Velocity(Velocity v) {
        this.dx = v.dx;
        this.dy = v.dy;
        this.angle = v.getAngle();
        this.speed = v.getSpeed();
    }

    /**
     * this method moves a point in two dimensions.
     *
     * @param p a point with position (x,y).
     * @return a new point with position (x+dx, y+dy).
     */
    public Point applyToPoint(Point p) {
        double newX = p.getX() + this.dx;
        double newY = p.getY() + this.dy;
        return new Point(newX, newY);
    }

    /**
     * this method calculates the velocity from its angle and speed.
     *
     * @param angle the angle (direction) of the movement.
     * @param speed the speed (how quick) the movement is.
     * @return gameSettings.Velocity the change in position on the x and y axes.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.cos(angle); //the change in x direction
        double dy = speed * Math.sin(angle); //the change in y direction
        return new Velocity(dx, dy);
    }

    /**
     * this method returns the angle from
     * the polar representation of this velocity.
     *
     * @return the angle from the polar representation of this velocity.
     */
    public double getAngle() {
        double myAngle = Math.toDegrees(Math.atan2(this.dy, this.dx)) + 90;
        if (myAngle < 0) {
            myAngle += 360;
        }
        return myAngle;
    }

    /**
     * this method re-sets the velocity's angle.
     *
     * @param myAngle the angle which the direction the velocity gets.
     */
    public void setAngle(double myAngle) {
        this.angle = myAngle;
    }

    /**
     * this method returns the "speed" (length) from the
     * polar representation of this velocity.
     *
     * @return the "speed" (length) from the
     * polar representation of this velocity.
     */
    public double getSpeed() {
        double speeds = Math.sqrt(this.dx * this.dx + this.dy * this.dy);
        return speed;
    }

    /**
     * this method re-sets the velocity's speed.
     *
     * @param mySpeed the speed that the velocity has.
     */
    public void setSpeed(double mySpeed) {
        this.speed = mySpeed;
    }

    /**
     * this method returns the velocity's change in position on the x axes.
     *
     * @return the velocity's change in position on the x axes.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * this method re-sets the dx - the velocity in the x axes.
     *
     * @param dxx the velocity in the x axes.
     */
    public void setDx(double dxx) {
        this.dx = dxx;
    }

    /**
     * this method returns the velocity's change in position on the y axes.
     *
     * @return the velocity's change in position on the y axes.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * this method re-sets the dy - the velocity in the x axes.
     *
     * @param dyy the velocity in the x axes.
     */
    public void setDy(double dyy) {
        this.dy = dyy;
    }
}