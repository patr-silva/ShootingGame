package io.codeforall.forsome;

import io.codeforall.forsome.characters.Enemy;
import io.codeforall.forsome.characters.Player;
import io.codeforall.forsome.grid.Grid;
import io.codeforall.forsome.level.Level;
import io.codeforall.forsome.level.LevelFactory;
import io.codeforall.forsome.weapons.Bullet;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;
import java.util.SortedMap;

public class CollideableManager {
    private static LinkedList<Collideable> collideablesList = new LinkedList<>();

    public static void addCollideable(Collideable collideable) {
        collideablesList.add(collideable);
    }

    public static void removeCollideable(Collideable collideable) {
        collideable.getPicture().delete();
        //collideablesList.remove(collideable);
    }

    public static void clearCollideableList() {
        for (Collideable c : collideablesList) {
            c.getPicture().delete();
        }

        collideablesList.clear();
    }
    public static void detectCollisions(Game game) {
        for(Collideable c : collideablesList) {
            if(!c.isDead()) {
                // player collisions
                if(c instanceof Player) {
                    // compare player position with other collideables
                    for(Collideable other : collideablesList) {
                        //exclude player
                        if(c.equals(other)) {
                            continue;
                        }

                        if(other instanceof Enemy) {
                            if(!other.isDead()) {
                                if(comparePositions(c,other)) {
                                    c.kill();
                                    System.out.println("fds suicidei-me?");
                                    break;
                                }
                            }
                        }

                        if(game.getLevel().getLevelEnded()) {
                            if(c.getPicture().getMaxX() >= game.getGrid().getWidth() - c.getPicture().getWidth()) {
                                System.out.println("Collision manager number of enemies: " + game.getLevel().getNumberOfEnemies() + 5);
                                game.setLevel(LevelFactory.createLevel(game.getGrid(),game.getLevel().getEnemySpeed() + 4, game.getLevel().getEnemySpawnInterval() - 25, game.getLevel().getScoreDeduction() + 30, game.getLevel().getScoreIncrement(), game.getLevel().getNumberOfEnemies() + 3, false));
                                break;
                            }
                        }
                    }
                    continue;
                }

                // enemy collisions
                if (c instanceof Enemy) {
                    if (c.getPicture().getMaxX() - c.getPicture().getWidth() / 2 <= 0) {
                        Game.score -= ((Enemy) c).getScoreDeduction();
                        c.kill();
                        //removeCollideable(c);
                        continue;
                    }

                }

                // bullet collisions
                if (c instanceof Bullet) {
                    if (c.getPicture().getMaxX() - c.getPicture().getWidth() / 2 >= game.getGrid().getWidth()) {
                        c.kill();
                        //removeCollideable(c);
                        continue;
                    }

                    for(Collideable other : collideablesList) {
                        //exclude player
                        if(c.equals(other)) {
                            continue;
                        }

                        if(other instanceof Enemy) {
                            if(!other.isDead()) {
                                if(comparePositions(other,c)) {
                                    System.out.println("entrou");
                                    ((Enemy) other).takeDamage(((Bullet) c).getDamage());
                                    c.kill();
                                    //removeCollideable(other);
                                    break;
                                }
                            }
                        }
                    }
                }
            }


        }
    }

    public static void show() {
        for(Collideable c : collideablesList) {
            if(!c.isDead()) {
                c.show();
            }
        }
    }

    public static void move() {
        for(Collideable c : collideablesList) {
            if (!c.isDead()) {
                try {
                    c.move();
                } catch (Exception e ) {
                    System.out.println("fodeu");
                }

            }
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
