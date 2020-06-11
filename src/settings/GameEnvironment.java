package settings;

import geometry.Line;
import geometry.Point;
import interfaces.Collidable;

import java.util.List;
import java.util.ArrayList;

/**
 * A class that represents the gameSettings.GameEnvironment -  a collection of collidable objects.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since: 06/05/2020
 */
public class GameEnvironment {
    private List<Collidable> collidableList = new ArrayList<Collidable>();

    /**
     * this method adds a given object into the gameSettings.GameEnvironment collidableList.
     *
     * @param c a collidable object that has bin added into the environment collidableList.
     */
    public void addCollidable(Collidable c) {
        this.collidableList.add(c);
    }

    /**
     * this mehtod removes a collidable object from the collidable list.
     *
     * @param c a collidable object that is goint to be removed from the the environment collidableList.
     */
    public void removeCollidable(Collidable c) {
        this.collidableList.remove(c);
    }

    /**
     * this method checks if the moving object will collide with any of the collidables in the collidables collection.
     * if doesnt collide - return null.
     * if does collide - return the information about the closest collision to occur (collision point & object).
     *
     * @param trajectory the line the moving object before the collision.
     * @return gameSettings.CollisionInfo of the closest collision that is going to occur, is no collision return null;
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        //no collidables in list
        if (this.collidableList.isEmpty()) {
            return null;
        }
        int i = 0;
        while (i < this.collidableList.size() && trajectory.closestIntersectionToStartOfLine(
                this.collidableList.get(i).getCollisionRectangle()) == null) {
            i++;
        }
        //no object col with tri
        if (i == this.collidableList.size()) {
            return null;
        }
        Point closestPoint = trajectory.closestIntersectionToStartOfLine(this.collidableList.get(i).
                getCollisionRectangle());
        int collisionIndex = i;
        for (int j = i; j < this.collidableList.size(); ++j) {
            if
            (trajectory.closestIntersectionToStartOfLine(this.collidableList.get(j).getCollisionRectangle()) != null) {
                if (closestPoint.distance(trajectory.start()) > trajectory.closestIntersectionToStartOfLine(
                        this.collidableList.get(j).getCollisionRectangle()).distance(trajectory.start())) {
                    closestPoint = trajectory.closestIntersectionToStartOfLine(
                            this.collidableList.get(j).getCollisionRectangle());
                    collisionIndex = j;
                }
            }
        }
        return new CollisionInfo(closestPoint, this.collidableList.get(collisionIndex));
    }
}