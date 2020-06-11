package geometry;

/**
 * A class represents a geometry.Point (x,y).
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 06/05/2020
 */
public class Point {
    private double x;
    private double y;

    /**
     * constructor that creates a point from the x coordinate and the y coordinate.
     *
     * @param x the x coordinate of this point.
     * @param y the y coordinate of this point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * constructor that creates a point from a diffrent points x coordinate and the y coordinate.
     *
     * @param p a diffrent point we want to use to create our point.
     */
    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * this method measures the distance from this (cornet) point to another point.
     *
     * @param other a point to measure distance to.
     * @return the distance of this point to the other point.
     */
    public double distance(Point other) {
        //calculate the distance
        double dx = this.x - other.getX();
        double dy = this.y - other.getY();
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    /**
     * this method checks if two points are the same.
     *
     * @param other point to compare with.
     * @return true if the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        if ((other == null) || (this == null)) {
            return false;
        }
        return (this.x == other.getX()) && (this.y == other.getY());
    }

    /**
     * this method returns the x value of this point.
     *
     * @return the x value of this point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * this method re-sets the x value of this point.
     *
     * @param theX the x value of this point.
     */
    public void setX(double theX) {
        this.x = theX;
    }

    /**
     * this method returns the y value of this point.
     *
     * @return the y value of this point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * this method re-sets the x value of this point.
     *
     * @param theY the y value of this point
     */
    public void setY(double theY) {
        this.y = theY;
    }
}