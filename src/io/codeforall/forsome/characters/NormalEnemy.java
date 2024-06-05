package io.codeforall.forsome.characters;

import io.codeforall.forsome.grid.Grid;

public class NormalEnemy extends Enemy {


    public NormalEnemy(int health, int speed, Grid grid, boolean isArmoured, int scoreDeduction, int scoreIncremented) {
        super(health, speed, grid, scoreDeduction, scoreIncremented);
        this.health = isArmoured ? this.health += 10 : this.health;
    }

    @Override
    public void kill() {

    }

    @Override
    public boolean isDead() {
        return false;
    }
}
