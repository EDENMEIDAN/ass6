package interfaces;

import settings.Velocity;
import geometry.Point;
import geometry.Rectangle;
import sprites.Ball;

/**
 * A interface that represents a collidable object.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 06/05/2020
 */
public interface Collidable {

    /**
     * this method return the collision object's shape.
     *
     * @return the collision object's shape.
     */
    Rectangle getCollisionRectangle();

    /**
     * this method receives collisionPoint & velocity then calculates the new velocity accordingly.
     *
     * @param hitter the hitting ball.
     * @param collisionPoint the point where both objects collide in to each-other.
     * @param currentVelocity the velocity the moving object is moving in.
     * @return the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}