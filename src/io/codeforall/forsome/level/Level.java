package io.codeforall.forsome.level;

import io.codeforall.forsome.characters.Enemy;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Level {

    private Picture ground;

    private Picture portal;

    private Enemy [] enemies;

    private Picture backGround;


    public Level(Picture backGround,Picture ground,Picture portal,Enemy[] enemies) {
        this.backGround = backGround;
        this.ground = ground;
        this.portal = portal;
        this.enemies = enemies;
    }



    public Picture getGround() {
        return ground;
    }

    public Picture getPortal() {
        return portal;
    }

    public Enemy[] getEnemies() {
        return enemies;
    }


    public Picture getBackground() {
        return backGround;
    }

    public void draw() {
        backGround.draw();
        ground.draw();
        portal.draw();

    }

    public void grow(double dw, double dh){
        backGround.grow(0,0);

        ground.grow(dw,dh);

        portal.grow(0,0);

    }



}


