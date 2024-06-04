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
                            System.out.println("Colidiu");
                        }
                    }
                }
            }

            // enemy collisions
            if(c instanceof Enemy) {
                if (c.getPicture().getMaxX() - c.getPicture().getWidth() / 2 <= 0) {
                    System.out.println("Sumiu cara");
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

        // get target corners
        int targetRightEdge = target.getPicture().getX() + target.getPicture().getWidth();
        int targetLeftEdge = target.getPicture().getX();

        int targetTopEdge = target.getPicture().getY();
        int targetBottomEdge = target.getPicture().getMaxY();

        // get invader middle position of image
        int invaderPosX = invader.getPicture().getX() + invader.getPicture().getWidth() / 2;
        int invaderPoxY = invader.getPicture().getY() + invader.getPicture().getHeight() / 2;

        // check if invader middle position is inside target image area
        if (invaderPosX <= targetRightEdge && invaderPosX >= targetLeftEdge && invaderPoxY >= targetTopEdge && invaderPoxY <= targetBottomEdge) {
            return true;
        }

        return false;

    }
}
