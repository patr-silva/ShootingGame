package io.codeforall.forsome.characters;

import io.codeforall.forsome.grid.Grid;

public class NoskEnemy extends Enemy {


    public NoskEnemy(int health, int speed, Grid grid) {
        super(health, speed, grid);
    }


    @Override
    public void setCollided() {

    }

    @Override
    public boolean getCollided() {
        return false;
    }


    @Override
    public void kill() {

    }

    @Override
    public boolean isDead() {
        return false;
    }
}
