package sprites;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import geometry.Point;
import geometry.Rectangle;
import interfaces.Collidable;
import interfaces.Sprite;
import levels.GameLevel;
import settings.Velocity;

import java.awt.Color;

/**
 * A class that represents a sprites.Paddle.
 *
 * @author Eden Meidan
 * @id: 207481177
 * @since 06/05/2020
 */
public class Paddle implements Sprite, Collidable {
    private static int paddleWidth = 50;
    private static int paddleHeight = 10;
    private Rectangle rect;
    private KeyboardSensor keyboard;

    /**
     * this method is a paddle constructor.
     *
     * @param rectangle the rectangle the paddle is make of.
     * @param keyboard the KeyboardSensor we use to move the paddle.
     */
    public Paddle(Rectangle rectangle, KeyboardSensor keyboard) {
        this.rect = rectangle;
        this.keyboard = keyboard;
    }

    /**
     * this method moves the paddle to the left.
     */
    public void moveLeft() {
        if (this.rect.getUpperLeft().getX() > 20) {
            //System.out.println("the 'left arrow' key is pressed");
            this.rect = new Rectangle(this.rect.getUpperLeft().getX() - paddleHeight, this.rect.getUpperLeft().getY(),
                    this.rect.getWidth(), this.rect.getHeight());
        }
    }

    /**
     * this method moves the paddle to the right.
     */
    public void moveRight() {
        if (this.rect.getUpperLeft().getX() + this.rect.getWidth() < 780) {
            //System.out.println("the 'right arrow' key is pressed");
            this.rect = new Rectangle(this.rect.getUpperLeft().getX() + paddleHeight, this.rect.getUpperLeft().getY(),
                    this.rect.getWidth(), this.rect.getHeight());
        }
    }

    /**
     * this method checks if the "left" or "right" keys are pressed, and if so moves the paddle accordingly.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * this method draws the paddle on to the screen.
     *
     * @param d the draw surface on the screen to draw on.
     */
    public void drawOn(DrawSurface d) {
        int rectWidth = (int) rect.getWidth();
        int recHeight = (int) rect.getHeight();

        int upperLeftX = (int) rect.getUpperLeft().getX();
        int upperLeftY = (int) rect.getUpperLeft().getY();

        d.setColor(Color.yellow);
        d.fillRectangle(upperLeftX, upperLeftY, rectWidth, recHeight);
        d.setColor(Color.black);
        d.drawRectangle(upperLeftX, upperLeftY, rectWidth, recHeight);
    }

    /**
     * this method returns the paddle's rectangle.
     *
     * @return the paddle's rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rect;
    }

    /**
     * This method returns the new velocity according to the part where the ball hits the paddle.
     * this method receives collisionPoint & velocity then calculates the new velocity accordingly.
     *
     * @param hitter the hitting ball.
     * @param collisionPoint the point where both objects collide.
     * @param currentVelocity the velocity the moving object is moving in.
     * @return the velocity according to the hit region on the paddle.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double paddleUpperLeftX = this.rect.getUpperLeft().getX();
        double collisionPointX = collisionPoint.getX();
        double paddlePart = (paddleWidth / 5);
        double speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
        // region 1 bounce back with an angle of 300 degrees (-60)
        if (collisionPointX <= paddleUpperLeftX + paddlePart) {
            return Velocity.fromAngleAndSpeed(300, speed);
        }
        //  region 2 bounce back 330 degrees (a little to the left)
        if (collisionPointX <= paddleUpperLeftX + 2 * paddlePart) {
            return Velocity.fromAngleAndSpeed(330, speed);
        }
        // region 3, keep horizontal direction and  change vertical one
        if (collisionPointX <= paddleUpperLeftX + 3 * paddlePart) {
            return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());
        }
        // region 4 bounce in 30 degrees
        if (collisionPointX <= paddleUpperLeftX + 4 * paddlePart) {
            return Velocity.fromAngleAndSpeed(30, speed);
        }
        return Velocity.fromAngleAndSpeed(60, speed); // region 5 bounce in 60 degrees.
    }

    /**
     * this method adds the paddle to the game.
     *
     * @param g the game to add the paddle to.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }

    /*
    this method removes paddle from the game.
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }*/
}