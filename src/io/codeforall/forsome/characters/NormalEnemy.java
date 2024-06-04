package io.codeforall.forsome.characters;

import io.codeforall.forsome.grid.Grid;

public class NormalEnemy extends Enemy{


    public NormalEnemy(int health, int speed, Grid grid, boolean isArmoured) {
        super(health, speed, grid);
        this.health = isArmoured ? this.health += 10 : this.health;
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
