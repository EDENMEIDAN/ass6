package settings;

import geometry.Point;
import interfaces.Collidable;

/**
 * A class that represents the information of a collision.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 06/05/2020
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * construct a collisionInfo object from collision point and collision object.
     *
     * @param collisionPoint the point where both objects collide.
     * @param collisionObject the object type the moving object collide with.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * construct a collisionInfo object from gameSettings.CollisionInfo of closestCollision.
     *
     * @param closestCollision the
     */
    public CollisionInfo(CollisionInfo closestCollision) {
        this.collisionPoint = closestCollision.collisionPoint;
        this.collisionObject = closestCollision.collisionObject;
    }

    /**
     * this method returns the point at which the collision occurs.
     *
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * this method returns the object type the moving object collide with.
     *
     * @return collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collisionObject;
    }
}