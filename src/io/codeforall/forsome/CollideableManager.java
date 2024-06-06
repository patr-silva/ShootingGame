package io.codeforall.forsome;

import io.codeforall.forsome.characters.Enemy;
import io.codeforall.forsome.characters.Player;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class CollideableManager {
    private static LinkedList<Collideable> collideablesList = new LinkedList<>();

    public static void addCollideable(Collideable collideable) {
        collideablesList.add(collideable);
    }

    public static void removeCollideable(Collideable collideable) {
        collideablesList.remove(collideable);
    }
    public static void clearCollideableList() {
        for (Collideable c : collideablesList) {
            c.getPicture().delete();
        }

        collideablesList.clear();
    }
    public static void detectCollisions() {
        for(Collideable c : collideablesList) {
            // player collisions
            if(c instanceof Player) {
                // compare player position with other collideables
                for(Collideable other : collideablesList) {
                    //exclude player
                    if(c.equals(other)) {
                        continue;
                    }

                    if(other instanceof Enemy) {
                        if(comparePositions(c,other)) {
                            c.kill();
                        }
                    }
                }
            }

            // enemy collisions
            if (c instanceof Enemy) {
                if (c.getPicture().getMaxX() - c.getPicture().getWidth() / 2 <= 0) {
                    Game.score -= ((Enemy) c).getScoreDeduction();
                    c.getPicture().delete();
                    removeCollideable(c);
                }
            }
        }
    }

    public static void show() {
        for(Collideable c : collideablesList) {
            c.show();
        }
    }

    public static void move() {
        for(Collideable c : collideablesList) {
            c.move();
        }
    }

    private static boolean comparePositions(Collideable target, Collideable invader) {

        // get target image edges
        int targetRightEdge = target.getPicture().getX() + target.getPicture().getWidth();
        int targetLeftEdge = target.getPicture().getX();

        int targetTopEdge = target.getPicture().getY();
        int targetBottomEdge = target.getPicture().getMaxY();


        // get x and y positions of each corner of invader
        int invaderUpperLeftCornerX = invader.getPicture().getX();
        int invaderUpperLeftCornerY = invader.getPicture().getY();

        int invaderLowerLeftCornerX = invader.getPicture().getX();
        int invaderLowerLeftCornerY = invader.getPicture().getY() + invader.getPicture().getHeight();

        int invaderUpperRightCornerX = invader.getPicture().getX() + invader.getPicture().getWidth();
        int invaderUpperRightCornerY = invader.getPicture().getY();

        int invaderLowerRightCornerX = invader.getPicture().getMaxX();
        int invaderLowerRightCornerY = invader.getPicture().getMaxY();

        // check if any corner from invader image is inside target image area
        if (invaderUpperLeftCornerX <= targetRightEdge && invaderUpperLeftCornerX >= targetLeftEdge && invaderUpperLeftCornerY >= targetTopEdge && invaderUpperLeftCornerY <= targetBottomEdge) {
            return true;
        }

        if (invaderLowerLeftCornerX <= targetRightEdge && invaderLowerLeftCornerX >= targetLeftEdge && invaderLowerLeftCornerY >= targetTopEdge && invaderLowerLeftCornerY <= targetBottomEdge) {
            return true;
        }

        if (invaderUpperRightCornerX <= targetRightEdge && invaderUpperRightCornerX >= targetLeftEdge && invaderUpperRightCornerY >= targetTopEdge && invaderUpperRightCornerY <= targetBottomEdge) {
            return true;
        }

        if (invaderLowerLeftCornerX <= targetRightEdge && invaderLowerRightCornerX >= targetLeftEdge && invaderLowerRightCornerY >= targetTopEdge && invaderLowerRightCornerY <= targetBottomEdge) {
            return true;
        }

        return false;

    }
}
