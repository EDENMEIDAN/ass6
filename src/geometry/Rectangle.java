package geometry;

import java.util.ArrayList;
import java.util.List;

/**
 * A class represents a geometry.Rectangle.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 06/05/2020
 */
public class Rectangle {
    private Line top;
    private Line bottom;
    private Line left;
    private Line right;
    private Point upperLeft;
    private double width;
    private double height;

    /**
     * constructor that creates a geometry.Rectangle from the upperLeft point, width and height.
     *
     * @param upperLeft the point location where the geometry.Rectangle starts on the upper left of the screen.
     * @param width the geometry.Rectangle's length in the x axis of the screen.
     * @param height the geometry.Rectangle's length in the y axis screen.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.left = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX(), upperLeft.getY() + height);
        this.right = new Line(upperLeft.getX() + width, upperLeft.getY(),
                upperLeft.getX() + width, upperLeft.getY() + height);
        this.top = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX() + width, upperLeft.getY());
        this.bottom = new Line(upperLeft.getX(), upperLeft.getY() + height,
                upperLeft.getX() + width, upperLeft.getY() + height);
    }

    /**
     * constructor that creates a geometry.Rectangle from two coordinates, width and height.
     *
     * @param x the x coordinate of the initial location of the rectangle's upper left corner.
     * @param y the y coordinate of the initial location of the rectangle's upper left corner.
     * @param width the rectangle's width.
     * @param height the rectangle's height.
     */
    public Rectangle(double x, double y, double width, double height) {
        this.left = new Line(x, y, x, y + height);
        this.right = new Line(x + width, y, x + width, y + height);
        this.top = new Line(x, y, x + width, y);
        this.bottom = new Line(x, y + height, x + width, y + height);
    }

    /**
     * this method returns the upperLeft of a geometry.Rectangle.
     *
     * @return upperLeft point of a geometry.Rectangle.
     */
    public Point getUpperLeft() {
        return this.top.intersectionWith(this.left);
    }

    /**
     * this method re-sets the geometry.Rectangle's upperLeft.
     *
     * @param theUpperLeft the new the geometry.Rectangle's upperLeft.
     */
    public void setUpperLeft(Point theUpperLeft) {
        this.upperLeft = theUpperLeft;
    }

    /**
     * this method returns the width of a geometry.Rectangle.
     *
     * @return width of a geometry.Rectangle.
     */
    public double getWidth() {
        return this.top.length();
    }

    /**
     * this method re-sets the width of a geometry.Rectangle.
     *
     * @param theWidth the new geometry.Rectangle's width.
     */
    public void setWidth(double theWidth) {
        this.width = theWidth;
    }

    /**
     * this method returns the height of a geometry.Rectangle.
     *
     * @return height of geometry.Rectangle.
     */
    public double getHeight() {
        return this.left.length();
    }

    /**
     * this method re-sets the geometry.Rectangle's height.
     *
     * @param theHeight of geometry.Rectangle.
     */
    public void setHeight(double theHeight) {
        this.height = theHeight;
    }

    /**
     * this method returns the rectangle's top line.
     *
     * @return the rectangle's top line.
     */
    public Line getTop() {
        return this.top;
    }

    /**
     * this method returns the rectangle's bottom line.
     *
     * @return the rectangle's bottom line.
     */
    public Line getBottom() {
        return this.bottom;
    }

    /**
     * this method returns the rectangle's left line.
     *
     * @return the rectangle's left line.
     */
    public Line getLeft() {
        return this.left;
    }

    /**
     * this method returns the rectangle's right line.
     *
     * @return the rectangle's right line.
     */
    public Line getRight() {
        return this.right;
    }

    /**
     * this method checks for intersection points with the specified line.
     *
     * @param line is the
     * @return a List of intersection points with the specified line. List can be possibly empty.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPointsList = new ArrayList<>(); //LinkedList;
        Point intersectingPoint = null;
        // right
        if (line.isIntersecting(this.right)) {
            intersectingPoint = line.intersectionWith(this.right);
            if (intersectingPoint != null) {
                intersectionPointsList.add(intersectingPoint);
            }
        }
        if (line.isIntersecting(this.left)) {
            intersectingPoint = line.intersectionWith(this.left);
            if (intersectingPoint != null) {
                intersectionPointsList.add(intersectingPoint);
            }
        }
        if (line.isIntersecting(this.top)) {
            intersectingPoint = line.intersectionWith(this.top);
            if (intersectingPoint != null) {
                intersectionPointsList.add(intersectingPoint);
            }
        }
        if (line.isIntersecting(this.bottom)) {
            intersectingPoint = line.intersectionWith(this.bottom);
            if (intersectingPoint != null) {
                intersectionPointsList.add(intersectingPoint);
            }
        }

        return intersectionPointsList;
    }
}