package geometry;

import java.util.List;

/**
 * A class that represents a line.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 14/04/2020
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * constructor that creates a line from 2 points that represent both line's tips.
     *
     * @param start is the starting point (x,y) that defines line.
     * @param end is the ending point (x,y) that defines line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * constructor from four coordinates.
     *
     * @param x1 the x coordinate of the starting point that defines the line.
     * @param y1 the y coordinate of the starting point that defines the line.
     * @param x2 the x coordinate of the ending point that defines the line.
     * @param y2 the y coordinate of the ending point that defines the line.
     */
    public Line(double x1, double y1, double x2, double y2) {
        do {
            start = new Point(x1, y1);
            end = new Point(x2, y2);
        }
        while (start.equals(end));
    }

    /**
     * this method measures the distance from the start point to the end point.
     *
     * @return the length of the line from the start point to its end point.
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * this method finds the middle point (x,y) of a line in the x and y axes.
     *
     * @return the middle point (x,y) of the line.
     */
    public Point middle() {
        double midX = ((start.getX() + end.getX()) / 2);
        double midY = ((start.getY() + end.getY()) / 2);
        Point middle = new Point(midX, midY);
        return middle;
    }

    /**
     * this method returns the start point (x,y) of a line.
     *
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * this method returns the end point (x,y) of a line.
     *
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * this method checks that the intersection point is actual and not out of the line's range.
     *
     * @param point the other line to check intersection with.
     * @return true if the intersection point is on both line's range, other wise returns false.
     */

    public boolean inBoundaries(Point point) {
        double epsilon = Math.pow(10, -5);
        double thisMaxX = Math.max(this.start.getX(), this.end.getX());
        double thisMinX = Math.min(this.start.getX(), this.end.getX());
        double thisMaxY = Math.max(this.start.getY(), this.end.getY());
        double thisMinY = Math.min(this.start.getY(), this.end.getY());

        if (point.getX() >= thisMinX - epsilon && point.getX() <= thisMaxX + epsilon && point.getY()
                >= thisMinY - epsilon && point.getY() <= thisMaxY + epsilon) {
            return true;
        }
        return false;
    }

    /**
     * this method returns the intersection point of to lines with each other.
     *
     * @param other the other line to check intersection with.
     * @return the intersection point (x,y) if the lines intersect otherwise null.
     */
    public boolean isIntersecting(Line other) {
        double aA = other.end.getY() - other.start.getY();
        double aB = this.end.getY() - this.start.getY();
        double bA = other.start.getX() - other.end.getX();
        double bB = this.start.getX() - this.end.getX();
        double cA = aA * other.start.getX() + bA * other.start.getY();
        double cB = aB * this.start.getX() + bB * this.start.getY();
        double delta = aB * bA - aA * bB;
        if (delta == 0) {  // Lines are parallel - no intersection
            return false;
        } else {
            double intersectionX = (bA * cB - bB * cA) / delta;
            double intersectionY = (aB * cA - aA * cB) / delta;
            Point intersection = new Point(intersectionX, intersectionY);
            return (this.inBoundaries(intersection) && other.inBoundaries(intersection));
        }
    }

    /**
     * this method calculating intersection point of two lines.
     *
     * @param other the other line to check intersection with.
     * @return the intersection point if the lines intersect, null otherwise.
     */
    public Point intersectionWith(Line other) {
        double aA = other.end.getY() - other.start.getY();
        double aB = this.end.getY() - this.start.getY();
        double bA = other.start.getX() - other.end.getX();
        double bB = this.start.getX() - this.end.getX();
        double cA = aA * other.start.getX() + bA * other.start.getY();
        double cB = aB * this.start.getX() + bB * this.start.getY();
        double delta = aB * bA - aA * bB;
        if (delta == 0) { // Lines are parallel - no intersection
            return null;
        } else { // their is an intersection
            double intersectionX = (bA * cB - bB * cA) / delta;
            double intersectionY = (aB * cA - aA * cB) / delta;
            Point intersection = new Point(intersectionX, intersectionY);
            if (this.inBoundaries(intersection) && other.inBoundaries(intersection)) {
                return intersection;
            } else {
                return null;
            }
        }
    }

    /**
     * this method checks if two given lines are equal to each other.
     *
     * @param other the other line to check if the current line is equal to.
     * @return true is the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        return ((other.end == this.end) && (other.start == this.start));
    }

    /**
     * this method checks if this line containing a given point.
     *
     * @param point the given point.
     * @return true if the line contains the point, false otherwise.
     */
    public boolean isContainingPoint(Point point) {
        if (point == null) { //not containing point
            return false;
        }
        // is containing point
        Line tempLine = new Line(this.start, point);
        Point tempPoint = tempLine.intersectionWith(this);
        return tempPoint == null && inBoundaries(point);
    }

    /**
     * this method finds if there is an intersection with the rectangle -
     * if so returns closest intersection point to the start of the line, otherwise returns null.
     *
     * @param rect the rectangle we are looking for an intersection with.
     * @return the closest intersection point to the start of the line, or null is there's no intersection.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersectionPointList = rect.intersectionPoints(this);
        if (!intersectionPointList.isEmpty()) { //no intersections
            if (intersectionPointList.size() == 1) { // only one intersection
                return intersectionPointList.get(0);
            } else { // more then one intersection
                if (intersectionPointList.size() == 2) {
                    double a = this.start.distance(intersectionPointList.get(0));
                    double b = this.start.distance(intersectionPointList.get(1));
                    if (a > b) {
                        return intersectionPointList.get(1);
                    } else {
                        return intersectionPointList.get(0);
                    }
                } else { // more then two intersections
                    for (Point point : intersectionPointList) {
                        double a = this.start.distance(intersectionPointList.get(0));
                        double b = this.start.distance(point);
                        Point closestIntersectionPoint = intersectionPointList.get(0);
                        if (a > b) {
                            closestIntersectionPoint = point;
                        }
                        return closestIntersectionPoint;
                    }
                }
            }
        }
        return null;
    }
}